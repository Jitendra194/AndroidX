package com.pills.createaccount.di.components

import com.pills.createaccount.di.modules.CreateAccountMainModule
import com.pills.createaccount.featureImpl.AccountCreationFeatureImpl
import com.pills.mydemoapplication.feature_package.AccountCreationFeature
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

@Component(
    modules = [CreateAccountMainModule::class],
    dependencies = [AccountCreationFeature.Dependencies::class]
)
interface CreateAccountMainComponent : AndroidInjector<AccountCreationFeatureImpl> {

    val createAccountComponentFactory: CreateAccountComponent.Factory

    val accountCreationFeatureImpl: AccountCreationFeatureImpl

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance testFeatureImpl: AccountCreationFeatureImpl,
            accountCreationFeature: AccountCreationFeature.Dependencies
        ): CreateAccountMainComponent
    }
}