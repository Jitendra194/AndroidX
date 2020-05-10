package com.pills.createaccount.utils

import android.view.View
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

object CreateAccountValidationErrorUtil {
    private const val emailRegex: String = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
    private const val passwordRegex: String = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&!+=])(?=\\S+\$).{8,}\$"

    fun isEmailValid(email: String) = Pattern.compile(emailRegex).matcher(email).matches()
    fun isPasswordValid(password: String) = Pattern.compile(passwordRegex).matcher(password).matches()
}


@BindingAdapter(value = ["dob", "gender", "phoneNumber", "formLength"], requireAll = true)
fun setSubmitButtonEnabledState(view: View, dob: Boolean, gender: Boolean, phoneNumber: Boolean, formLength: Boolean) {
    view.isEnabled = !dob && !gender && !phoneNumber && formLength
}

@BindingAdapter(value = ["firstName", "lastName", "mobileNumber", "email", "password", "formLength"], requireAll = false)
fun setNextButtonEnabledState(view: View, firstName: Boolean, lastName: Boolean, mobileNumber: Boolean, email: Boolean, password: Boolean, formLength: Boolean) {
    view.isEnabled = !firstName && !lastName && !mobileNumber && !email && !password && formLength
}

@BindingAdapter(value = ["errorTextBool", "errorText"])
fun isErrorTrue(view: TextInputLayout, errorTextBool: Boolean, errorText: String) {
    if (errorTextBool) view.error = errorText
    else view.error = null
}