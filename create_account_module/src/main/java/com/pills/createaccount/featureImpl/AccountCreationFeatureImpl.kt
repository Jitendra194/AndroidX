package com.pills.createaccount.featureImpl

import android.content.Context
import android.content.Intent
import com.google.auto.service.AutoService
import com.pills.createaccount.di.components.CreateAccountMainComponent
import com.pills.createaccount.di.components.DaggerCreateAccountMainComponent
import com.pills.createaccount.views.CreateAccountActivity
import com.pills.mydemoapplication.feature_package.AccountCreationFeature

internal lateinit var createAccountMainComponent: CreateAccountMainComponent
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