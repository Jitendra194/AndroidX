package com.pills.home_hq.views

import androidx.lifecycle.ViewModel
import com.pills.mydemoapplication.feature_package.FeatureManager
import com.pills.mydemoapplication.feature_package.FeatureName.*
import com.pills.mydemoapplication.feature_package.getFeature
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val featureManager: FeatureManager) : ViewModel() {

    fun launchPillsHub() = featureManager getFeature PillsFeature

    fun launchLabReportsHub() = featureManager getFeature LabReportsFeature

    fun launchMyPrescriptionsHub() = featureManager getFeature PrescriptionsFeature

    fun launchWellnessTipsHub() = featureManager getFeature WellnessTipsFeature
}