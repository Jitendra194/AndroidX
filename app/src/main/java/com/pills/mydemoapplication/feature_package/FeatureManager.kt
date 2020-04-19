package com.pills.mydemoapplication.feature_package

import com.pills.mydemoapplication.feature_package.FeatureName.*
import com.pills.mydemoapplication.base_application.appComponent
import java.util.*

class FeatureManager {

    infix fun getFeature(featureName: FeatureName) = when (featureName) {
        AccountCreationFeature -> injectFeature<AccountCreationFeature, AccountCreationFeature.Dependencies>(appComponent.accountCreationFeature)
        PillsFeature -> injectFeature<PillsFeature, PillsFeature.Dependencies>(appComponent.pillsFeature)
        LabReportsFeature -> injectFeature<LabReportsFeature, LabReportsFeature.Dependencies>(appComponent.labReportsFeature)
        PrescriptionsFeature -> injectFeature<PrescriptionsFeature, PrescriptionsFeature.Dependencies>(appComponent.prescriptionsFeature)
        WellnessTipsFeature -> injectFeature<WellnessTipsFeature, WellnessTipsFeature.Dependencies>(appComponent.wellnessTipsFeature)
        LoginFeature -> injectFeature<LoginFeature, LoginFeature.Dependencies>(appComponent.loginFeature)
    }

    private inline fun <reified T : Feature<D>, D> injectFeature(
        dependencies: D
    ): T? {
        val serviceIterator = ServiceLoader.load(
            T::class.java,
            T::class.java.classLoader
        ).iterator()

        return if (serviceIterator.hasNext()) {
            (serviceIterator.next()).apply { inject(dependencies) }
        } else {
            null
        }
    }
}