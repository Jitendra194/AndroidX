package com.pills.mydemoapplication.repository.network.interceptors

import android.content.SharedPreferences
import com.pills.mydemoapplication.repository.SessionManager.Companion.AUTH_TOKEN
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val sharedPreferences: SharedPreferences) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.request().newBuilder()
            .addHeader(
                "Authorization",
                "Bearer ${sharedPreferences.getString(AUTH_TOKEN, null)}"
            )
            .build().let {
                chain.proceed(it)
            }
    }
}