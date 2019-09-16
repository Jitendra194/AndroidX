package com.example.mydemoapplication.dagger

import com.example.mydemoapplication.LoginFragment
import com.example.mydemoapplication.viewmodel_factory.LoginViewModelProviderModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuilderModule {

    @ContributesAndroidInjector(modules = [LoginViewModelProviderModule::class])
    abstract fun contributesLoginFragment(): LoginFragment
}