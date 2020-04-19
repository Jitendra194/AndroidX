package com.pills.login_module.views

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.pills.mydemoapplication.base_application.BaseApplicationClass
import com.pills.mydemoapplication.feature_package.AccountCreationFeature
import com.pills.mydemoapplication.feature_package.FeatureManager
import com.pills.mydemoapplication.feature_package.FeatureName
import com.pills.mydemoapplication.feature_package.info
import com.pills.mydemoapplication.views.HQActivity
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val application: BaseApplicationClass,
    private val featureManager: FeatureManager) : ViewModel() {

    fun launchSignupScreen(): Intent? {
        return (featureManager.getFeature(FeatureName.AccountCreationFeature))?.getLaunchIntent(application)
    }

    fun launchHQ(): Intent? {
        return Intent(application, HQActivity::class.java)
    }
}
