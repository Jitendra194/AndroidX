package com.pills.login_module.views

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.pills.mydemoapplication.base_application.BaseApplicationClass
import com.pills.mydemoapplication.feature_package.*
import com.pills.mydemoapplication.views.HQActivity
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val application: BaseApplicationClass,
    private val featureManager: FeatureManager,
    private val googleSignInClient: GoogleSignInClient
) : ViewModel() {

    private val _featureEvent = MutableLiveData<FeatureName>()
    val isFeatureEventTriggered: LiveData<FeatureName>
        get() = _featureEvent

    init {
        featureManager.registerInstallListener { featureName -> _featureEvent.value = featureName }
    }

    //ToDo: Work on a better implementation
    fun isCreateAccountFeatureInstalled() = featureManager.isFeatureInstalled(FeatureName.AccountCreationFeature)

    fun installCreateAccountFeature() = featureManager.installFeature(FeatureName.AccountCreationFeature)

    fun launchSignupScreen() = (featureManager.getFeature(FeatureName.AccountCreationFeature))?.getLaunchIntent(application)

    fun launchHQ() = Intent(application, HQActivity::class.java)

    override fun onCleared() {
        super.onCleared()
        featureManager.unregisterInstallListener { _featureEvent.value = it }
    }
}
