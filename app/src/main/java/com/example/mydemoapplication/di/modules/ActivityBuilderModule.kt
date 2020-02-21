package com.example.mydemoapplication.di.modules

import com.example.mydemoapplication.views.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [LoginViewModelProviderModule::class])
    abstract fun contributeMainActivity(): MainActivity
}