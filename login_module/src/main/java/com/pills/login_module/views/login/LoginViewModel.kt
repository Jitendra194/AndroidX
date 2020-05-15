package com.pills.login_module.views.login

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
    private val mGoogleSignInClient: GoogleSignInClient
) : ViewModel() {

    fun launchHQ() = Intent(application, HQActivity::class.java)
}
