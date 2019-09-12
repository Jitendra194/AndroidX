package com.example.mydemoapplication.base_application

import com.example.mydemoapplication.dagger.DaggerBaseApplicaitionComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplicationClass : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerBaseApplicaitionComponent.builder().application(this).build()
    }
}