package com.example.mydemoapplication.dagger

import android.app.Application
import com.example.mydemoapplication.base_application.BaseApplicationClass
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [BaseApplicationModule::class, AndroidInjectionModule::class,
])
interface BaseApplicaitionComponent : AndroidInjector<BaseApplicationClass> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): BaseApplicaitionComponent
    }
}