package com.pills.createaccount.views

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import javax.inject.Inject

class CreateAccountMethodViewModel @Inject constructor(
    private val mGoogleSignInClient: GoogleSignInClient) : ViewModel() {

    companion object {
        const val RC_SIGN_IN: Int = 0
    }

    fun getGoogleSignInIntent(): Intent = mGoogleSignInClient.signInIntent

    fun handleSignInResult(task: Task<GoogleSignInAccount>, onSuccess: (String) -> Unit, onFailure: (ApiException?) -> Unit) {
        try {
            task.getResult(ApiException::class.java)?.let { onSuccess.invoke(it.givenName ?: "") } ?: onFailure.invoke(null)
        } catch (e: ApiException) {
            onFailure.invoke(e)
        }
    }
}