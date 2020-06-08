package com.pills.home_hq.featureImpl

import com.pills.home_hq.di.components.HomeFeatureMainComponent
import com.google.auto.service.AutoService
import com.pills.home_hq.di.components.DaggerHomeFeatureMainComponent
import com.pills.mydemoapplication.feature_package.HomeFeature

internal lateinit var homeFeatureMainComponent: HomeFeatureMainComponent
    private set

@AutoService(HomeFeature::class)
class HomeFeatureImpl : HomeFeature {
    override fun inject(dependencies: HomeFeature.Dependencies) {
        if (::homeFeatureMainComponent.isInitialized) {
            return
        } else {
            homeFeatureMainComponent =
                DaggerHomeFeatureMainComponent.factory().create(this, dependencies)
        }
    }
}