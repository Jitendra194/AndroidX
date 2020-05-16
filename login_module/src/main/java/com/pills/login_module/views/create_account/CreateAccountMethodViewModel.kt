package com.pills.login_module.views.create_account

import android.content.Intent
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.pills.login_module.utils.CreateAccountValidationErrorUtil
import javax.inject.Inject

class CreateAccountMethodViewModel @Inject constructor(
    private val mGoogleSignInClient: GoogleSignInClient) : ViewModel() {

    val firstName = ObservableField<String>()
    val lastName = ObservableField<String>()
    val mobileNumber = ObservableField<String>()
    val email = ObservableField<String>()
    val password = ObservableField<String>()

    val firstNameError = ObservableBoolean(false)
    val lastNameError = ObservableBoolean(false)
    val mobileNumberError = ObservableBoolean(false)
    val emailError = ObservableBoolean(false)
    val passwordError = ObservableBoolean(false)

    private val _buttonState = MutableLiveData(false)
    val buttonState: LiveData<Boolean>
        get() = _buttonState.apply {
            value = !firstName.get().isNullOrBlank() && !lastName.get().isNullOrBlank() && !mobileNumber.get().isNullOrBlank() && !password.get().isNullOrBlank() && !emailError.get()
        }

    fun getGoogleSignInIntent(): Intent = mGoogleSignInClient.signInIntent

    fun onFirstNameChanged(s: CharSequence) = firstNameError.set(s.isBlank())

    fun onLastNameChanged(s: CharSequence) = lastNameError.set(s.isBlank())

    fun onEmailChanged(s: CharSequence) = emailError.set(s.contains(" ") || !CreateAccountValidationErrorUtil.isEmailValid(s.toString()) && s.isNotEmpty())

    fun onMobileNumberChanged(s: CharSequence) = mobileNumberError.set(s.contains(" ") || s.length < 10)

    fun onPasswordChanged(s: CharSequence) = passwordError.set(!CreateAccountValidationErrorUtil.isPasswordValid(s.toString()))
}