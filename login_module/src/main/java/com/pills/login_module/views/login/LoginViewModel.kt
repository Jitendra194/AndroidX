package com.pills.login_module.views.login

import android.content.Intent
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.pills.login_module.repository.LoginRepository
import com.pills.login_module.utils.State
import com.pills.login_module.utils.State.FAILURE
import com.pills.login_module.utils.State.SUCCESS
import com.pills.mydemoapplication.base_application.BaseApplicationClass
import com.pills.mydemoapplication.repository.SessionManager.Companion.IS_USER_LOGGED_IN
import com.pills.mydemoapplication.views.hq.HQActivity
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val application: BaseApplicationClass,
    private val mGoogleSignInClient: GoogleSignInClient,
    private val loginRepository: LoginRepository,
    private val sharedPreferences: SharedPreferences) : ViewModel() {

    val username = ObservableField<String>()
    val password = ObservableField<String>()

    private val _launchLogin = MutableLiveData<State?>(null)
    val launch: LiveData<State?>
        get() = _launchLogin

    fun loginGetUserData() {
        viewModelScope.launch {
            try {
                username.get()?.let {
                    loginRepository.fetchUserData(it)
                    sharedPreferences.edit { putBoolean(IS_USER_LOGGED_IN, true) }
                    _launchLogin.value = SUCCESS
                } ?: throw Throwable()
            } catch (e: Throwable) {
                _launchLogin.value = FAILURE
                e.printStackTrace()
            }
        }
    }

    fun getGoogleSignInIntent(): Intent = mGoogleSignInClient.signInIntent

    fun launchHQ() = Intent(application, HQActivity::class.java)
}
