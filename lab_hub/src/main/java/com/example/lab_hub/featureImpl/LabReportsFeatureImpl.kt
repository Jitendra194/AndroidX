package com.example.lab_hub.featureImpl

import android.content.Context
import android.content.Intent
import com.example.lab_hub.di.components.DaggerLabReportsFeatureMainComponent
import com.example.lab_hub.di.components.LabReportsFeatureMainComponent
import com.example.mydemoapplication.feature_package.LabReportsFeature
import com.google.auto.service.AutoService

lateinit var labReportsFeatureMainComponent: LabReportsFeatureMainComponent
    private set

@AutoService(LabReportsFeature::class)
class LabReportsFeatureImpl : LabReportsFeature {
    override fun getLaunchIntent(context: Context): Intent {
        TODO("Not yet implemented")
    }

    override fun inject(dependencies: LabReportsFeature.Dependencies) {
        if (::labReportsFeatureMainComponent.isInitialized) {
            return
        } else {
            labReportsFeatureMainComponent =
                DaggerLabReportsFeatureMainComponent.factory().create(this, dependencies)
        }
    }
}