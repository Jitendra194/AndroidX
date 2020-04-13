package com.pills.pills_hub.di.components

import com.pills.mydemoapplication.feature_package.PillsFeature
import com.pills.pills_hub.di.modules.PillsFeatureMainModule
import com.pills.pills_hub.featureImpl.PillsFeatureImpl
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

@Component(
    modules = [PillsFeatureMainModule::class],
    dependencies = [PillsFeature.Dependencies::class]
)
interface PillsFeatureMainComponent : AndroidInjector<PillsFeatureImpl> {

    val pillsFeatureComponent: PillsFeatureComponent.Factory
    val pillsFeatureImpl: PillsFeatureImpl

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance pillsFeatureImpl: PillsFeatureImpl,
            pillsFeature: PillsFeature.Dependencies
        ): PillsFeatureMainComponent
    }
}