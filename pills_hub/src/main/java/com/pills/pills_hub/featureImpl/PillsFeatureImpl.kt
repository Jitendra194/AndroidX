package com.pills.pills_hub.featureImpl

import android.content.Context
import android.content.Intent
import com.google.auto.service.AutoService
import com.pills.mydemoapplication.feature_package.PillsFeature
import com.pills.pills_hub.di.components.DaggerPillsFeatureMainComponent
import com.pills.pills_hub.di.components.PillsFeatureMainComponent

internal lateinit var pillsFeatureMainComponent: PillsFeatureMainComponent
    private set

@AutoService(PillsFeature::class)
class PillsFeatureImpl : PillsFeature {
    override fun inject(dependencies: PillsFeature.Dependencies) {
        if (::pillsFeatureMainComponent.isInitialized) {
            return
        } else {
            pillsFeatureMainComponent =
                DaggerPillsFeatureMainComponent.factory().create(this, dependencies)
        }
    }
}