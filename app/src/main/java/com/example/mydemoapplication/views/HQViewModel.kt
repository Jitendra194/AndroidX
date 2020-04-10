package com.example.mydemoapplication.views

import androidx.lifecycle.ViewModel
import com.example.mydemoapplication.feature_package.*
import javax.inject.Inject

class HQViewModel @Inject constructor(
    private val featureManager: FeatureManager,
    private val pillsFeature: PillsFeature.Dependencies,
    private val labReportsFeature: LabReportsFeature.Dependencies,
    private val prescriptionsFeature: PrescriptionsFeature.Dependencies,
    private val wellnessTipsFeature: WellnessTipsFeature.Dependencies
) : ViewModel() {

    fun launchPillsHub() {
        featureManager.getFeature<PillsFeature, PillsFeature.Dependencies>(pillsFeature)
    }

    fun launchLabReportsHub() {
        featureManager.getFeature<LabReportsFeature, LabReportsFeature.Dependencies>(labReportsFeature)
    }

    fun launchMyPrescriptionsHub() {
        featureManager.getFeature<PrescriptionsFeature, PrescriptionsFeature.Dependencies>(prescriptionsFeature)
    }

    fun launchWellnessTipsHub() {
        featureManager.getFeature<WellnessTipsFeature, WellnessTipsFeature.Dependencies>(wellnessTipsFeature)
    }
}
