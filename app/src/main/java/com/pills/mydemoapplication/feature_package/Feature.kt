package com.pills.mydemoapplication.feature_package

import android.content.Context
import android.content.Intent
import com.pills.mydemoapplication.R
import com.pills.mydemoapplication.base_application.BaseApplicationClass
import kotlin.reflect.KClass

enum class FeatureName(val moduleName: String) {
    AccountCreationFeature("create_account_module"),
    PillsFeature("pills_hub"),
    LabReportsFeature("lab_hub"),
    PrescriptionsFeature("prescriptions_hub"),
    WellnessTipsFeature("wellnessTips_hub"),
    LoginFeature("login_module")
}

fun <T : Feature<*>> KClass<T>.info(context: Context) = when (this) {
    AccountCreationFeature::class -> Feature.Info(
        id = FeatureName.AccountCreationFeature,
        name = context.getString(R.string.create_account)
    )
    else -> throw IllegalArgumentException("Unexpected feature $this")
}

interface Feature<T> {
    fun getLaunchIntent(context: Context): Intent
    fun inject(dependencies: T)

    data class Info(
        val id: FeatureName,
        val name: String
    )
}

interface AccountCreationFeature : Feature<AccountCreationFeature.Dependencies> {
    interface Dependencies {
        val application: BaseApplicationClass
    }
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
    }
}