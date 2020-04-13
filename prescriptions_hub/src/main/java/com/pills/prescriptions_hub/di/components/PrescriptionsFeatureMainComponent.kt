package com.pills.prescriptions_hub.di.components

import com.pills.mydemoapplication.feature_package.PrescriptionsFeature
import com.pills.prescriptions_hub.di.modules.PrescriptionsFeatureMainModule
import com.pills.prescriptions_hub.featureImpl.PrescriptionsFeatureImpl
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

@Component(
    modules = [PrescriptionsFeatureMainModule::class],
    dependencies = [PrescriptionsFeature.Dependencies::class]
)
interface PrescriptionsFeatureMainComponent : AndroidInjector<PrescriptionsFeatureImpl> {

    val prescriptionsFeatureComponent: PrescriptionsFeatureComponent.Factory
    val prescriptionsFeatureImpl: PrescriptionsFeatureImpl

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance prescriptionsFeatureImpl: PrescriptionsFeatureImpl,
            prescriptionsFeature: PrescriptionsFeature.Dependencies
        ): PrescriptionsFeatureMainComponent
    }
}