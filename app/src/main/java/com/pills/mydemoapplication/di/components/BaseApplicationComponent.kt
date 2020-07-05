package com.pills.mydemoapplication.di.components

import com.pills.mydemoapplication.base_application.BaseApplicationClass
import com.pills.mydemoapplication.di.modules.*
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelFactoryModule
import com.pills.mydemoapplication.feature_package.*
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
        AppModule::class,
        NetworkModule::class,
        ServiceModule::class]
)
interface BaseApplicationComponent : AndroidInjector<BaseApplicationClass> {

    val pillsFeature: PillsFeature.Dependencies
    val labReportsFeature: LabReportsFeature.Dependencies
    val prescriptionsFeature: PrescriptionsFeature.Dependencies
    val wellnessTipsFeature: WellnessTipsFeature.Dependencies
    val loginFeature: LoginFeature.Dependencies
    val homeFeature: HomeFeature.Dependencies

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: BaseApplicationClass): BaseApplicationComponent
    }
}