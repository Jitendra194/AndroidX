package com.pills.login_module.views.login

import android.content.Intent
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.pills.login_module.repository.LoginRepository
import com.pills.login_module.utils.LoginState
import com.pills.login_module.utils.LoginState.FAILURE
import com.pills.login_module.utils.LoginState.SUCCESS
import com.pills.mydemoapplication.base_application.BaseApplicationClass
import com.pills.mydemoapplication.views.hq.HQActivity
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val application: BaseApplicationClass,
    private val mGoogleSignInClient: GoogleSignInClient,
    private val loginRepository: LoginRepository
) : ViewModel() {

    val username = ObservableField<String>()
    val password = ObservableField<String>()

    private val _launchLogin = MutableLiveData<LoginState?>(null)
    val launchLogin: LiveData<LoginState?>
        get() = _launchLogin

    fun loginGetUserData() {
        viewModelScope.launch {
            try {
                loginRepository.fetchUserData(username.get() ?: "")
                _launchLogin.value = SUCCESS
            } catch (e: Throwable) {
                _launchLogin.value = FAILURE
                e.printStackTrace()
            }
        }
    }

    fun getGoogleSignInIntent(): Intent = mGoogleSignInClient.signInIntent

    fun launchHQ() = Intent(application, HQActivity::class.java)
}
