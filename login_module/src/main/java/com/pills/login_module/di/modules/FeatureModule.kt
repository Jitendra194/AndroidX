package com.pills.login_module.di.modules

import com.pills.login_module.di.components.CreateAccountComponent
import com.pills.login_module.di.components.GoogleUserDetailsComponent
import com.pills.login_module.di.components.LoginComponent
import com.pills.login_module.di.scopes.LoginScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(subcomponents = [LoginComponent::class, CreateAccountComponent::class, GoogleUserDetailsComponent::class])
object FeatureModule {
    @Provides
    fun providesRetrofitClient(retrofit: Retrofit.Builder): Retrofit {
        return retrofit.baseUrl("https://popit-dev-ed.my.salesforce.com/services/apexrest/").build()
    }
}