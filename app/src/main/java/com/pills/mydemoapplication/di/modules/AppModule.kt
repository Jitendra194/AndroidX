package com.pills.mydemoapplication.di.modules

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.pills.mydemoapplication.base_application.BaseApplicationClass
import com.pills.mydemoapplication.feature_package.FeatureManager
import com.pills.mydemoapplication.feature_package.FeatureManagerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {
    @Provides
    @Singleton
    fun providesFeatureManager(application: BaseApplicationClass): FeatureManager = FeatureManagerImpl(application)

    @Provides
    @Singleton
    fun providesGoogleSignInOptions(): GoogleSignInOptions {
        return GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
    }

    @Provides
    @Singleton
    fun providesGoogleSignInClient(application: BaseApplicationClass, signInOptions: GoogleSignInOptions): GoogleSignInClient {
        return GoogleSignIn.getClient(application, signInOptions)
    }
}