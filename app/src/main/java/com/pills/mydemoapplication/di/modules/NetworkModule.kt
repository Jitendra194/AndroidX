package com.pills.mydemoapplication.di.modules

import android.content.SharedPreferences
import com.pills.mydemoapplication.repository.network.interceptors.AuthInterceptor
import com.pills.mydemoapplication.repository.SessionManager
import com.pills.mydemoapplication.repository.network.services.TokenService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {
    @Provides
    @Singleton
    fun providesGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().also {
            it.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(authInterceptor: AuthInterceptor, httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providesRetrofitBuilder(gsonConverterFactory: GsonConverterFactory, okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder().client(okHttpClient).addConverterFactory(gsonConverterFactory)
    }

    @Provides
    @Singleton
    fun providesSessionManager(sharedPreferences: SharedPreferences, tokenService: TokenService): SessionManager =
        SessionManager(
            sharedPreferences,
            tokenService
        )

    @Provides
    @Singleton
    fun providesAuthInterceptor(sharedPreferences: SharedPreferences): AuthInterceptor =
        AuthInterceptor(
            sharedPreferences
        )
}