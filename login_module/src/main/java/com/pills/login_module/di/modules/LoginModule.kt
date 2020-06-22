package com.pills.login_module.di.modules

import com.pills.login_module.di.scopes.LoginScope
import com.pills.login_module.repository.LoginRepository
import com.pills.login_module.repository.services.LoginService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object LoginModule {
    @Provides
    @LoginScope
    fun providesLoginService(retrofit: Retrofit): LoginService = retrofit.create(LoginService::class.java)

    @Provides
    @LoginScope
    fun providesLoginRepository(loginService: LoginService) = LoginRepository(loginService)
}