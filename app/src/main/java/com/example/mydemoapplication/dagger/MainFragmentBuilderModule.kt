package com.example.mydemoapplication.dagger

import com.example.mydemoapplication.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesLoginFragment(): LoginFragment
}