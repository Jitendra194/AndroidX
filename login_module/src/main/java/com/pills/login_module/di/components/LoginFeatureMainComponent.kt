package com.pills.login_module.di.components

import com.pills.login_module.featureImpl.LoginFeatureImpl
import com.pills.login_module.di.modules.FeatureModule
import com.pills.login_module.di.scopes.LoginScope
import com.pills.mydemoapplication.feature_package.LoginFeature
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

@Component(
    dependencies = [LoginFeature.Dependencies::class],
    modules = [FeatureModule::class]
)
interface LoginFeatureMainComponent : AndroidInjector<LoginFeatureImpl> {

    val loginComponent: LoginComponent.Factory
    val createAccountComponent: CreateAccountComponent.Factory
    val googleUserDetailsComponent: GoogleUserDetailsComponent.Factory
    val phoneExtraUserDetailsComponent: PhoneExtraUserDetailsComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance loginFeatureImpl: LoginFeatureImpl, loginFeature: LoginFeature.Dependencies): LoginFeatureMainComponent
    }
}