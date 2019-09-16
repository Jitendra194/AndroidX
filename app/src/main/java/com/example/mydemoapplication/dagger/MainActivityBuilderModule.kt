package com.example.mydemoapplication.dagger

import com.example.mydemoapplication.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}