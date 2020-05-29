package com.pills.mydemoapplication.feature_package

import android.widget.Toast
import com.google.android.play.core.splitinstall.*
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import com.pills.mydemoapplication.base_application.BaseApplicationClass
import com.pills.mydemoapplication.feature_package.FeatureName.*
import com.pills.mydemoapplication.base_application.appComponent
import java.util.*

infix fun FeatureManager.getFeature(featureName: FeatureName) = selectFeature(featureName)

private inline fun <reified T : Feature<D>, D> FeatureManager.injectFeature(
    dependencies: D, featureName: FeatureName
): T? {
    return if (isFeatureInstalled(featureName)) {
        val serviceIterator = ServiceLoader.load(
            T::class.java,
            T::class.java.classLoader
        ).iterator()

        if (serviceIterator.hasNext()) {
            (serviceIterator.next()).apply { inject(dependencies) }
        } else {
            null
        }
    } else {
        null
    }
}

private fun FeatureManager.selectFeature(featureName: FeatureName) = when (featureName) {
    PillsFeature -> injectFeature<PillsFeature, PillsFeature.Dependencies>(appComponent.pillsFeature, featureName)
    LabReportsFeature -> injectFeature<LabReportsFeature, LabReportsFeature.Dependencies>(appComponent.labReportsFeature, featureName)
    PrescriptionsFeature -> injectFeature<PrescriptionsFeature, PrescriptionsFeature.Dependencies>(appComponent.prescriptionsFeature, featureName)
    WellnessTipsFeature -> injectFeature<WellnessTipsFeature, WellnessTipsFeature.Dependencies>(appComponent.wellnessTipsFeature, featureName)
    LoginFeature -> injectFeature<LoginFeature, LoginFeature.Dependencies>(appComponent.loginFeature, featureName)
}

fun FeatureManager.installFeature(featureName: FeatureName) = downloadFeature(featureName)

fun FeatureManager.isFeatureInstalled(featureName: FeatureName): Boolean = isFeatureDownloaded(featureName)

interface FeatureManager {
    fun downloadFeature(featureName: FeatureName)
    fun isFeatureDownloaded(featureName: FeatureName): Boolean
    fun registerInstallListener(listener: (FeatureName) -> Unit)
    fun unregisterInstallListener(listener: (FeatureName) -> Unit)
}

internal class FeatureManagerImpl(private val application: BaseApplicationClass) : FeatureManager {

    private val splitInstallManager: SplitInstallManager = SplitInstallManagerFactory.create(application)
    private val installListeners = mutableListOf<(FeatureName) -> Unit>()

    override fun downloadFeature(featureName: FeatureName) {
        val request = SplitInstallRequest.newBuilder()
            .addModule(featureName.moduleName)
            .build()

        val installStateUpdateListener = object : SplitInstallStateUpdatedListener {
            override fun onStateUpdate(state: SplitInstallSessionState) {
                state.moduleNames().forEach { moduleName ->
                    when (state.status()) {
                        SplitInstallSessionStatus.CANCELED -> {
                            splitInstallManager.unregisterListener(this)
                            Toast.makeText(application, "CANCELED $moduleName = ${state.status()}", Toast.LENGTH_SHORT).show()
                        }
                        SplitInstallSessionStatus.CANCELING -> {
                            Toast.makeText(application, "CANCELING $moduleName = ${state.status()}", Toast.LENGTH_SHORT).show()
                        }
                        SplitInstallSessionStatus.DOWNLOADED -> {
                            Toast.makeText(application, "DOWNLOADED $moduleName = ${state.status()}", Toast.LENGTH_SHORT).show()
                        }
                        SplitInstallSessionStatus.DOWNLOADING -> {
                            Toast.makeText(application, "DOWNLOADING $moduleName = ${state.status()}", Toast.LENGTH_SHORT).show()
                        }
                        SplitInstallSessionStatus.FAILED -> {
                            splitInstallManager.unregisterListener(this)
                            Toast.makeText(application, "FAILED $moduleName = ${state.status()}", Toast.LENGTH_SHORT).show()
                        }
                        SplitInstallSessionStatus.INSTALLED -> {
                            splitInstallManager.unregisterListener(this)
                            installListeners.forEach { listener -> listener(featureName) }
                            Toast.makeText(application, "INSTALLED $moduleName = ${state.status()}", Toast.LENGTH_SHORT).show()
                        }
                        SplitInstallSessionStatus.INSTALLING -> {
                            Toast.makeText(application, "INSTALLING $moduleName = ${state.status()}", Toast.LENGTH_SHORT).show()
                        }
                        SplitInstallSessionStatus.PENDING -> {
                            Toast.makeText(application, "PENDING $moduleName = ${state.status()}", Toast.LENGTH_SHORT).show()
                        }
                        SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> {
                            Toast.makeText(application, "REQUIRES_USER_CONFIRMATION $moduleName = ${state.status()}", Toast.LENGTH_SHORT).show()
                        }
                        SplitInstallSessionStatus.UNKNOWN -> {
                            splitInstallManager.unregisterListener(this)
                            Toast.makeText(application, "UNKNOWN $moduleName = ${state.status()}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

        splitInstallManager.registerListener(installStateUpdateListener)
        splitInstallManager.startInstall(request)
    }

    override fun isFeatureDownloaded(featureName: FeatureName): Boolean {
        return splitInstallManager.installedModules.contains(featureName.moduleName)
    }

    override fun registerInstallListener(listener: (FeatureName) -> Unit) {
        installListeners.add(listener)
    }

    override fun unregisterInstallListener(listener: (FeatureName) -> Unit) {
        installListeners.remove(listener)
    }
}