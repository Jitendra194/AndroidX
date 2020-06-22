package com.pills.mydemoapplication.di.modules

import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.pills.mydemoapplication.base_application.BaseApplicationClass
import com.pills.mydemoapplication.feature_package.FeatureManager
import com.pills.mydemoapplication.feature_package.FeatureManagerImpl
import com.pills.mydemoapplication.repository.AuthInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Provides
    @Singleton
    fun providesGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build()
    }

    @Provides
    @Singleton
    fun providesRetrofitBuilder(gsonConverterFactory: GsonConverterFactory, okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder().client(okHttpClient).addConverterFactory(gsonConverterFactory)
    }
}