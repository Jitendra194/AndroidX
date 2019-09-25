package com.example.mydemoapplication.dagger

import android.app.Application
import com.example.mydemoapplication.base_application.BaseApplicationClass
import com.example.mydemoapplication.viewmodel_factory.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Suppress("unused")
@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        ViewModelFactoryModule::class]
)
interface BaseApplicationComponent : AndroidInjector<BaseApplicationClass> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): BaseApplicationComponent
    }
}