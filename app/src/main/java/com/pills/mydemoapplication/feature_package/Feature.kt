package com.pills.mydemoapplication.feature_package

import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.pills.mydemoapplication.base_application.BaseApplicationClass

enum class FeatureName(val moduleName: String) {
    PillsFeature("pills_hub"),
    LabReportsFeature("lab_hub"),
    PrescriptionsFeature("prescriptions_hub"),
    WellnessTipsFeature("wellnessTips_hub"),
    LoginFeature("login_module"),
    HomeFeature("home_hq")
}

interface Feature<T> {
    fun inject(dependencies: T)
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

interface HomeFeature : Feature<HomeFeature.Dependencies> {
    interface Dependencies {
        val application: BaseApplicationClass
        val featureManager: FeatureManager
    }
}

interface LoginFeature : Feature<LoginFeature.Dependencies> {
    interface Dependencies {
        val application: BaseApplicationClass
        val featureManager: FeatureManager
        val googleSignInClient: GoogleSignInClient
    }
}