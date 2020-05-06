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
object CreateAccountModule {

    @Provides
    @CreateAccountScope
    fun providesCreateAccountActivityContext(activity: CreateAccountActivity): Context = activity.baseContext

    @Provides
    @CreateAccountScope
    fun providesResources(context: Context): Resources = context.resources

    @Provides
    @CreateAccountScope
    fun providesGoogleSignInOptions(): GoogleSignInOptions {
        return GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
    }

    @Provides
    @CreateAccountScope
    fun providesGoogleSignInClient(context: Context, signInOptions: GoogleSignInOptions): GoogleSignInClient {
        return GoogleSignIn.getClient(context, signInOptions)
    }
}