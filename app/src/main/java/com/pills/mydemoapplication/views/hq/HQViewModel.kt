package com.pills.mydemoapplication.views.hq

import androidx.lifecycle.ViewModel
import com.pills.mydemoapplication.feature_package.FeatureName.PillsFeature
import com.pills.mydemoapplication.feature_package.FeatureName.LabReportsFeature
import com.pills.mydemoapplication.feature_package.FeatureName.PrescriptionsFeature
import com.pills.mydemoapplication.feature_package.FeatureName.WellnessTipsFeature
import com.pills.mydemoapplication.feature_package.*
import javax.inject.Inject

class HQViewModel @Inject constructor(private val featureManager: FeatureManager) : ViewModel() {

    fun launchPillsHub() = featureManager getFeature PillsFeature

    fun launchLabReportsHub() = featureManager getFeature LabReportsFeature

    fun launchMyPrescriptionsHub() = featureManager getFeature PrescriptionsFeature

    fun launchWellnessTipsHub() = featureManager getFeature WellnessTipsFeature
}
