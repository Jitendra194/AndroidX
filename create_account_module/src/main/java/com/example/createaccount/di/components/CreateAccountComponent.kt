package com.example.createaccount.di.components

import com.example.createaccount.di.modules.view_builder_modules.CreateAccountFragmentBuilderModule
import com.example.createaccount.views.CreateAccountActivity
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Subcomponent(
    modules = [CreateAccountFragmentBuilderModule::class,
        AndroidInjectionModule::class]
)
interface CreateAccountComponent : AndroidInjector<CreateAccountActivity> {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance createAccountActivity: CreateAccountActivity): CreateAccountComponent
    }
}