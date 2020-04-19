package com.pills.login_module.featureImpl

import android.content.Context
import android.content.Intent
import com.google.auto.service.AutoService
import com.pills.login_module.di.components.DaggerLoginFeatureMainComponent
import com.pills.login_module.di.components.LoginFeatureMainComponent
import com.pills.mydemoapplication.feature_package.LoginFeature

internal lateinit var loginFeatureMainComponent: LoginFeatureMainComponent
    private set

@AutoService(LoginFeature::class)
class LoginFeatureImpl : LoginFeature {
    override fun getLaunchIntent(context: Context): Intent {
        TODO("Not yet implemented")
    }

    override fun inject(dependencies: LoginFeature.Dependencies) {
        if (::loginFeatureMainComponent.isInitialized) {
            return
        } else {
            loginFeatureMainComponent =
                DaggerLoginFeatureMainComponent.factory().create(this, dependencies)
        }
    }
}