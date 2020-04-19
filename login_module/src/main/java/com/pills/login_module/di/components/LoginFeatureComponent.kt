package com.pills.login_module.di.components

import com.pills.login_module.views.LoginFragment
import com.pills.login_module.di.modules.ViewModelProviderModule
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Subcomponent(
    modules = [AndroidInjectionModule::class,
        ViewModelProviderModule::class]
)
interface LoginFeatureComponent : AndroidInjector<LoginFragment> {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance loginFragment: LoginFragment): LoginFeatureComponent
    }
}