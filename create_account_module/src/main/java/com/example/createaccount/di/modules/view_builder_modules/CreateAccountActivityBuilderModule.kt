package com.example.createaccount.di.modules.view_builder_modules

import com.example.createaccount.views.CreateAccountActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class CreateAccountActivityBuilderModule {
    @ContributesAndroidInjector(modules = [CreateAccountFragmentBuilderModule::class])
    abstract fun contributesCreateAccountActivity(): CreateAccountActivity
}