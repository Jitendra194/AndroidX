package com.pills.mydemoapplication.feature_package

import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.pills.mydemoapplication.R
import com.pills.mydemoapplication.base_application.BaseApplicationClass
import kotlin.reflect.KClass

enum class FeatureName(val moduleName: String) {
    PillsFeature("pills_hub"),
    LabReportsFeature("lab_hub"),
    PrescriptionsFeature("prescriptions_hub"),
    WellnessTipsFeature("wellnessTips_hub"),
    LoginFeature("login_module")
}

interface Feature<T> {
    fun getLaunchIntent(context: Context): Intent
    fun inject(dependencies: T)

    data class Info(
        val id: FeatureName,
        val name: String
    )
}

interface PillsFeature : Feature<PillsFeature.Dependencies> {
    interface Dependencies {
        val application: BaseApplicationClass
    }
}

interface LabReportsFeature : Feature<LabReportsFeature.Dependencies> {
    interface Dependencies {
        val application: BaseApplicationClass
    }
}

interface PrescriptionsFeature : Feature<PrescriptionsFeature.Dependencies> {
    interface Dependencies {
        val application: BaseApplicationClass
    }
}

interface WellnessTipsFeature : Feature<WellnessTipsFeature.Dependencies> {
    interface Dependencies {
        val application: BaseApplicationClass
    }
}

interface LoginFeature : Feature<LoginFeature.Dependencies> {
    interface Dependencies {
        val application: BaseApplicationClass
        val featureManager: FeatureManager
        val googleSignInClient: GoogleSignInClient
    }
}