package com.example.createaccount.featureImpl

import android.content.Context
import android.content.Intent
import com.example.createaccount.di.components.CreateAccountMainComponent
import com.example.createaccount.di.components.DaggerCreateAccountMainComponent
import com.example.createaccount.views.CreateAccountActivity
import com.example.mydemoapplication.feature_package.AccountCreationFeature
import com.google.auto.service.AutoService

lateinit var createAccountMainComponent: CreateAccountMainComponent
    private set

@AutoService(AccountCreationFeature::class)
class AccountCreationFeatureImpl : AccountCreationFeature {

    override fun getLaunchIntent(context: Context): Intent {
        return Intent(context, CreateAccountActivity::class.java)
    }

    override fun inject(dependencies: AccountCreationFeature.Dependencies) {
        if (::createAccountMainComponent.isInitialized) {
            return
        } else{
            createAccountMainComponent = DaggerCreateAccountMainComponent.factory().create(this, dependencies)
        }
    }
}