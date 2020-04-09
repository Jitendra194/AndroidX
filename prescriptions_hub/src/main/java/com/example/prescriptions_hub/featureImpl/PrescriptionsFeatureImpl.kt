package com.example.prescriptions_hub.featureImpl

import android.content.Context
import android.content.Intent
import com.example.mydemoapplication.feature_package.PrescriptionsFeature
import com.example.prescriptions_hub.di.components.DaggerPrescriptionsFeatureMainComponent
import com.example.prescriptions_hub.di.components.PrescriptionsFeatureMainComponent
import com.google.auto.service.AutoService

lateinit var prescriptionsFeatureMainComponent: PrescriptionsFeatureMainComponent
    private set

@AutoService(PrescriptionsFeature::class)
class PrescriptionsFeatureImpl : PrescriptionsFeature {
    override fun getLaunchIntent(context: Context): Intent {
        TODO("Not yet implemented")
    }

    override fun inject(dependencies: PrescriptionsFeature.Dependencies) {
        if (::prescriptionsFeatureMainComponent.isInitialized) {
            return
        } else {
            prescriptionsFeatureMainComponent =
                DaggerPrescriptionsFeatureMainComponent
                    .factory()
                    .create(this, dependencies)
        }
    }
}