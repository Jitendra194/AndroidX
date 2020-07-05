package com.pills.mydemoapplication.di.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.pills.mydemoapplication.R
import com.pills.mydemoapplication.base_application.BaseApplicationClass
import com.pills.mydemoapplication.feature_package.FeatureManager
import com.pills.mydemoapplication.feature_package.FeatureManagerImpl
import com.pills.mydemoapplication.repository.local.database.AppDatabase
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
    fun providesSharedPreferences(application: BaseApplicationClass): SharedPreferences {
        return application.getSharedPreferences(application.getString(R.string.app_name), Context.MODE_PRIVATE)
    }

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

    @Provides
    @Singleton
    fun providesDatabase(application: BaseApplicationClass): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "database-name").build()
    }
}