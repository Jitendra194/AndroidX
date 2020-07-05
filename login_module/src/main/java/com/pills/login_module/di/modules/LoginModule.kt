package com.pills.login_module.di.modules

import com.pills.login_module.di.scopes.LoginScope
import com.pills.login_module.repository.LoginRepository
import com.pills.login_module.repository.services.LoginService
import com.pills.mydemoapplication.repository.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object LoginModule {
    @Provides
    @LoginScope
    fun providesLoginService(retrofit: Retrofit.Builder): LoginService {
        return retrofit.baseUrl("https://popit-dev-ed.my.salesforce.com/services/apexrest/")
            .build()
            .create(LoginService::class.java)
    }

    @Provides
    @LoginScope
    fun providesLoginRepository(loginService: LoginService, roomDatabase: AppDatabase) = LoginRepository(loginService, roomDatabase)
}