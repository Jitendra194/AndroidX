package com.pills.createaccount.di.modules.view_builder_modules

import com.pills.createaccount.di.modules.ViewModelProviderModule
import com.pills.createaccount.views.EnterUserDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class CreateAccountFragmentBuilderModule {

    @ContributesAndroidInjector(modules = [ViewModelProviderModule::class])
    abstract fun contributesEnterUserDetailsFragment(): EnterUserDetailsFragment
}