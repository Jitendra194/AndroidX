package com.pills.wellnesstips_hub.di.components

import com.pills.mydemoapplication.feature_package.WellnessTipsFeature
import com.pills.wellnesstips_hub.di.modules.WellnessTipsFeatureMainModule
import com.pills.wellnesstips_hub.featureImpl.WellnessTipsFeatureImpl
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

@Component(
    modules = [WellnessTipsFeatureMainModule::class],
    dependencies = [WellnessTipsFeature.Dependencies::class]
)
interface WellnessTipsFeatureMainComponent : AndroidInjector<WellnessTipsFeatureImpl> {

    val wellnessTipsFeatureComponent: WellnessTipsFeatureComponent.Factory
    val wellnessTipsFeatureImpl: WellnessTipsFeatureImpl

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance wellnessTipsFeatureImpl: WellnessTipsFeatureImpl,
            wellnessTipsFeature: WellnessTipsFeature.Dependencies
        ): WellnessTipsFeatureMainComponent
    }
}