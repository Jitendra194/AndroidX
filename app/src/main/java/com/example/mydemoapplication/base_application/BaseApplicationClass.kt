package com.example.mydemoapplication.base_application

import com.example.mydemoapplication.di.components.BaseApplicationComponent
import com.example.mydemoapplication.di.components.DaggerBaseApplicationComponent
import com.google.android.play.core.splitcompat.SplitCompatApplication
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class BaseApplicationClass : SplitCompatApplication(), HasAndroidInjector {

    private lateinit var appComponent: BaseApplicationComponent

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingActivityInjector

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerBaseApplicationComponent.factory().create(this)
        appComponent.inject(this)
    }
}