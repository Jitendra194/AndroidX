package com.pills.mydemoapplication.views

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.pills.mydemoapplication.base_application.BaseApplicationClass
import com.pills.mydemoapplication.feature_package.AccountCreationFeature
import com.pills.mydemoapplication.feature_package.FeatureManager
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val application: BaseApplicationClass,
    private val featureManager: FeatureManager,
    private val accountCreationFeature: AccountCreationFeature.Dependencies
) : ViewModel() {

    fun launchSignupScreen(): Intent? {
        return (featureManager.getFeature<AccountCreationFeature, AccountCreationFeature.Dependencies>(accountCreationFeature))
            ?.getLaunchIntent(application)
    }

    fun launchHQ(): Intent? {
        return Intent(application, HQActivity::class.java)
    }
}