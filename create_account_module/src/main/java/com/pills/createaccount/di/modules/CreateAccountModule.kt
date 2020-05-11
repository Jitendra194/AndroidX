package com.pills.createaccount.di.modules

import android.content.Context
import android.content.res.Resources
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.pills.createaccount.di.scopes.CreateAccountScope
import com.pills.createaccount.views.CreateAccountActivity
import dagger.Module
import dagger.Provides

@Module
object CreateAccountModule