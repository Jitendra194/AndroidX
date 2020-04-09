package com.example.lab_hub.di.components

import com.example.lab_hub.featureImpl.LabReportsFeatureImpl
import com.example.lab_hub.di.modules.LabReportsFeatureMainModule
import com.example.mydemoapplication.feature_package.LabReportsFeature
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

@Component(
    modules = [LabReportsFeatureMainModule::class],
    dependencies = [LabReportsFeature.Dependencies::class]
)
interface LabReportsFeatureMainComponent : AndroidInjector<LabReportsFeatureImpl> {

    val labReportsFeatureComponent: LabReportsFeatureComponent.Factory
    val labReportsFeatureImpl: LabReportsFeatureImpl

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance labReportsFeatureImpl: LabReportsFeatureImpl,
            labReportsFeature: LabReportsFeature.Dependencies
        ): LabReportsFeatureMainComponent
    }
}