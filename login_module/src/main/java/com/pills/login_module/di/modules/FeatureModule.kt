package com.pills.login_module.di.modules

import com.pills.login_module.di.components.CreateAccountComponent
import com.pills.login_module.di.components.GoogleUserDetailsComponent
import com.pills.login_module.di.components.LoginComponent
import com.pills.login_module.di.components.PhoneExtraUserDetailsComponent
import dagger.Module

@Module(subcomponents = [LoginComponent::class, CreateAccountComponent::class, GoogleUserDetailsComponent::class, PhoneExtraUserDetailsComponent::class])
object FeatureModule