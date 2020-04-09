package com.example.wellnesstips_hub.featureImpl

import android.content.Context
import android.content.Intent
import com.example.mydemoapplication.feature_package.WellnessTipsFeature
import com.example.wellnesstips_hub.di.components.DaggerWellnessTipsFeatureMainComponent
import com.example.wellnesstips_hub.di.components.WellnessTipsFeatureMainComponent
import com.google.auto.service.AutoService

lateinit var wellnessTipsFeatureMainComponent: WellnessTipsFeatureMainComponent
    private set

@AutoService(WellnessTipsFeature::class)
class WellnessTipsFeatureImpl : WellnessTipsFeature {
    override fun getLaunchIntent(context: Context): Intent {
        TODO("Not yet implemented")
    }

    override fun inject(dependencies: WellnessTipsFeature.Dependencies) {
        if (::wellnessTipsFeatureMainComponent.isInitialized) {
            return
        } else {
            wellnessTipsFeatureMainComponent =
                DaggerWellnessTipsFeatureMainComponent.factory().create(this, dependencies)
        }
    }
}