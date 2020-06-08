package com.pills.home_hq.di.components

import com.pills.home_hq.di.modules.HomeFeatureMainModule
import com.pills.home_hq.featureImpl.HomeFeatureImpl
import com.pills.mydemoapplication.feature_package.HomeFeature
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

@Component(
    dependencies = [HomeFeature.Dependencies::class],
    modules = [HomeFeatureMainModule::class]
)
interface HomeFeatureMainComponent : AndroidInjector<HomeFeatureImpl> {

    val featureComponent: FeatureComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance homeFeatureImpl: HomeFeatureImpl, homeFeature: HomeFeature.Dependencies): HomeFeatureMainComponent
    }
}