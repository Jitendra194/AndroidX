package com.example.mydemoapplication.di.modules

import com.example.mydemoapplication.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [LoginViewModelProviderModule::class])
    abstract fun contributeMainActivity(): MainActivity
}