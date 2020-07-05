package com.pills.mydemoapplication.di.modules

import com.pills.mydemoapplication.repository.network.services.TokenService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object ServiceModule {
    @Provides
    @Singleton
    fun providesTokenService(retrofit: Retrofit.Builder): TokenService {
        return retrofit.baseUrl("https://login.salesforce.com/services/oauth2/")
            .build()
            .create(TokenService::class.java)
    }
}
