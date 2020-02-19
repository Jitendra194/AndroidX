package com.example.createaccount.di.components

import com.example.createaccount.AccountCreationFeatureImpl
import com.example.createaccount.di.modules.CreateAccountMainModule
import com.example.mydemoapplication.di.viewmodel_factory.LoginScope
import com.example.mydemoapplication.feature_package.AccountCreationFeature
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton


@LoginScope
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