package com.example.createaccount.di.modules.view_builder_modules

import com.example.createaccount.di.modules.ViewModelProviderModule
import com.example.createaccount.views.EnterUserDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class CreateAccountFragmentBuilderModule {

    @ContributesAndroidInjector(modules = [ViewModelProviderModule::class])
    abstract fun contributesEnterUserDetailsFragment(): EnterUserDetailsFragment
}