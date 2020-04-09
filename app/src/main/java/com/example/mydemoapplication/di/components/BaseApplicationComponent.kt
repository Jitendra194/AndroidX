package com.example.mydemoapplication.di.components

import com.example.mydemoapplication.base_application.BaseApplicationClass
import com.example.mydemoapplication.di.modules.ActivityBuilderModule
import com.example.mydemoapplication.di.modules.AppModule
import com.example.mydemoapplication.di.modules.FeaturesModule
import com.example.mydemoapplication.di.modules.ViewModelFactoryModule
import com.example.mydemoapplication.feature_package.FeatureManager
import com.example.mydemoapplication.feature_package.AccountCreationFeature
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
        FeaturesModule::class,
        ViewModelFactoryModule::class,
        AppModule::class]
)
interface BaseApplicationComponent : AndroidInjector<BaseApplicationClass> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: BaseApplicationClass): BaseApplicationComponent
    }
}