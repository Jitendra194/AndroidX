package com.example.mydemoapplication.dagger

import com.example.mydemoapplication.LoginFragment
import com.example.mydemoapplication.viewmodel_factory.LoginScope
import com.example.mydemoapplication.viewmodel_factory.LoginViewModelProviderModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class MainFragmentBuilderModule {

    @LoginScope
    @ContributesAndroidInjector(modules = [LoginViewModelProviderModule::class])
    abstract fun contributesLoginFragment(): LoginFragment
}