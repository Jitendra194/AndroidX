package com.pills.mydemoapplication.base_application

import com.google.android.play.core.splitcompat.SplitCompatApplication
import com.pills.mydemoapplication.di.components.BaseApplicationComponent
import com.pills.mydemoapplication.di.components.DaggerBaseApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

internal lateinit var appComponent: BaseApplicationComponent
    private set

class BaseApplicationClass : SplitCompatApplication(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingActivityInjector

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerBaseApplicationComponent.factory().create(this)
        appComponent.inject(this)
    }
}