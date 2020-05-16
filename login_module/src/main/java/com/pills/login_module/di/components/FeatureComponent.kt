package com.pills.login_module.di.components

import com.pills.login_module.di.modules.viewmodel_providers.CreateAccountViewModelProviderModule
import com.pills.login_module.di.modules.viewmodel_providers.EnterUserDetailsViewModelProviderModule
import com.pills.login_module.di.modules.viewmodel_providers.LoginViewModelProviderModule
import com.pills.login_module.views.create_account.CreateAccountMethodFragment
import com.pills.login_module.views.google_extra.EnterUserDetailsFragment
import com.pills.login_module.views.login.LoginFragment
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Subcomponent(modules = [AndroidInjectionModule::class, LoginViewModelProviderModule::class])
interface LoginComponent : AndroidInjector<LoginFragment> {
    @Subcomponent.Factory
    interface Factory { fun create(@BindsInstance loginFragment: LoginFragment): LoginComponent }
}

@Subcomponent(modules = [AndroidInjectionModule::class, CreateAccountViewModelProviderModule::class])
interface CreateAccountComponent : AndroidInjector<CreateAccountMethodFragment> {
    @Subcomponent.Factory
    interface Factory { fun create(@BindsInstance createAccountMethodFragment: CreateAccountMethodFragment): CreateAccountComponent }
}

@Subcomponent(modules = [AndroidInjectionModule::class, EnterUserDetailsViewModelProviderModule::class])
interface GoogleUserDetailsComponent : AndroidInjector<EnterUserDetailsFragment> {
    @Subcomponent.Factory
    interface Factory { fun create(@BindsInstance enterUserDetailsFragment: EnterUserDetailsFragment): GoogleUserDetailsComponent }
}