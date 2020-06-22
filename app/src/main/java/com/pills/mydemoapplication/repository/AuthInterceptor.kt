package com.pills.mydemoapplication.repository

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.request().newBuilder()
            .addHeader(
                "Authorization",
                "Bearer 00D4R000001WtMp!AREAQKUyf.ArggQYJmKpAPBjRZ7T.df85JNb2vSbvz6.ZgQpa_xVXr7k8mqOxPArPz4Cmp3UL6CCdSbyIe4NV3ybpo2IuHWc"
            )
            .build().let {
                chain.proceed(it)
            }
    }
}