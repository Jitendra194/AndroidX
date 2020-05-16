package com.pills.login_module.utils

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task


internal const val RC_SIGN_IN: Int = 0

internal inline fun Task<GoogleSignInAccount>.handleSignInResult(onSuccess: (String) -> Unit, onFailure: (ApiException?) -> Unit) {
    try {
        getResult(ApiException::class.java)?.let { onSuccess(it.givenName ?: "") } ?: onFailure(null)
    } catch (e: ApiException) {
        onFailure(e)
    }
}