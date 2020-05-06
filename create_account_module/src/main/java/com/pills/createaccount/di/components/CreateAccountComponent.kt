package com.pills.createaccount.di.components

import com.pills.createaccount.di.modules.CreateAccountModule
import com.pills.createaccount.di.modules.view_builder_modules.CreateAccountFragmentBuilderModule
import com.pills.createaccount.di.scopes.CreateAccountScope
import com.pills.createaccount.views.CreateAccountActivity
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@CreateAccountScope
@Subcomponent(
    modules = [CreateAccountFragmentBuilderModule::class,
        CreateAccountModule::class,
        AndroidInjectionModule::class]
)
interface CreateAccountComponent : AndroidInjector<CreateAccountActivity> {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance createAccountActivity: CreateAccountActivity): CreateAccountComponent
    }
}