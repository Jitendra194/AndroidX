package com.example.mydemoapplication.base_application

import com.example.mydemoapplication.dagger.DaggerBaseApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplicationClass : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerBaseApplicationComponent.builder().application(this).build()
}