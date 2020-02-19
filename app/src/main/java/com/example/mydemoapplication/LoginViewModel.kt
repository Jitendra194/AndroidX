package com.example.mydemoapplication

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.mydemoapplication.base_application.BaseApplicationClass
import com.example.mydemoapplication.feature_package.*
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val application: BaseApplicationClass,
    private val featureManager: FeatureManager,
    private val accountCreationFeature: AccountCreationFeature.Dependencies
) : ViewModel() {

    fun test(): Intent? {
        return (featureManager.getFeature<AccountCreationFeature, AccountCreationFeature.Dependencies>(accountCreationFeature))
            ?.getLaunchIntent(application)
    }
}