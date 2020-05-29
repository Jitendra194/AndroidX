package com.pills.prescriptions_hub.featureImpl

import android.content.Context
import android.content.Intent
import com.pills.mydemoapplication.feature_package.PrescriptionsFeature
import com.pills.prescriptions_hub.di.components.PrescriptionsFeatureMainComponent
import com.google.auto.service.AutoService
import com.pills.prescriptions_hub.di.components.DaggerPrescriptionsFeatureMainComponent

internal lateinit var prescriptionsFeatureMainComponent: PrescriptionsFeatureMainComponent
    private set

@AutoService(PrescriptionsFeature::class)
class PrescriptionsFeatureImpl : PrescriptionsFeature {
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