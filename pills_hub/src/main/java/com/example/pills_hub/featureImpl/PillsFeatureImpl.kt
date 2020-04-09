package com.example.pills_hub.featureImpl

import android.content.Context
import android.content.Intent
import com.example.mydemoapplication.feature_package.PillsFeature
import com.example.pills_hub.di.components.DaggerPillsFeatureMainComponent
import com.example.pills_hub.di.components.PillsFeatureMainComponent
import com.google.auto.service.AutoService

lateinit var pillsFeatureMainComponent: PillsFeatureMainComponent
    private set

@AutoService(PillsFeature::class)
class PillsFeatureImpl : PillsFeature {
    override fun getLaunchIntent(context: Context): Intent {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun inject(dependencies: PillsFeature.Dependencies) {
        if (::pillsFeatureMainComponent.isInitialized) {
            return
        } else {
            pillsFeatureMainComponent =
                DaggerPillsFeatureMainComponent.factory().create(this, dependencies)
        }
    }
}