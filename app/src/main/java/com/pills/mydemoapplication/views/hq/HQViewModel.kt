package com.pills.mydemoapplication.views.hq

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.pills.mydemoapplication.feature_package.FeatureManager
import com.pills.mydemoapplication.feature_package.FeatureName.*
import com.pills.mydemoapplication.feature_package.getFeature
import com.pills.mydemoapplication.repository.SessionManager.Companion.AUTH_TOKEN
import javax.inject.Inject

class HQViewModel @Inject constructor(private val featureManager: FeatureManager) : ViewModel() {

    fun launchHome() = featureManager getFeature HomeFeature

    fun launchPillsHub() = featureManager getFeature PillsFeature

    fun launchLabReportsHub() = featureManager getFeature LabReportsFeature

    fun launchMyPrescriptionsHub() = featureManager getFeature PrescriptionsFeature

    fun launchWellnessTipsHub() = featureManager getFeature WellnessTipsFeature
}
