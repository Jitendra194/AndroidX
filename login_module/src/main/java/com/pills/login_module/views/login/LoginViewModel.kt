package com.pills.login_module.views.login

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.pills.mydemoapplication.base_application.BaseApplicationClass
import com.pills.mydemoapplication.views.hq.HQActivity
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val application: BaseApplicationClass,
    private val mGoogleSignInClient: GoogleSignInClient
) : ViewModel() {

    fun getGoogleSignInIntent(): Intent = mGoogleSignInClient.signInIntent

    fun launchHQ() = Intent(application, HQActivity::class.java)
}
