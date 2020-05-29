package com.pills.wellnesstips_hub.featureImpl

import android.content.Context
import android.content.Intent
import com.pills.mydemoapplication.feature_package.WellnessTipsFeature
import com.pills.wellnesstips_hub.di.components.DaggerWellnessTipsFeatureMainComponent
import com.pills.wellnesstips_hub.di.components.WellnessTipsFeatureMainComponent
import com.google.auto.service.AutoService

internal lateinit var wellnessTipsFeatureMainComponent: WellnessTipsFeatureMainComponent
    private set

@AutoService(WellnessTipsFeature::class)
class WellnessTipsFeatureImpl : WellnessTipsFeature {
    override fun inject(dependencies: WellnessTipsFeature.Dependencies) {
        if (::wellnessTipsFeatureMainComponent.isInitialized) {
            return
        } else {
            wellnessTipsFeatureMainComponent =
                DaggerWellnessTipsFeatureMainComponent.factory().create(this, dependencies)
        }
    }
}