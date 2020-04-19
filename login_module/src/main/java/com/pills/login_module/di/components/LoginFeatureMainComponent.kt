package com.pills.login_module.di.components

import com.pills.login_module.featureImpl.LoginFeatureImpl
import com.pills.login_module.di.modules.LoginFeatureMainModule
import com.pills.mydemoapplication.feature_package.LoginFeature
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

@Component(
    dependencies = [LoginFeature.Dependencies::class],
    modules = [LoginFeatureMainModule::class]
)
interface LoginFeatureMainComponent : AndroidInjector<LoginFeature.Dependencies> {

    val loginFeatureComponent: LoginFeatureComponent.Factory
    val loginFeatureImpl: LoginFeatureImpl

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance loginFeatureImpl: LoginFeatureImpl,
            loginFeature: LoginFeature.Dependencies
        ): LoginFeatureMainComponent
    }
}