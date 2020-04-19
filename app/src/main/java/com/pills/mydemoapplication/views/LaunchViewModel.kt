package com.pills.mydemoapplication.views

import androidx.lifecycle.ViewModel
import com.pills.mydemoapplication.feature_package.FeatureManager
import com.pills.mydemoapplication.feature_package.FeatureName.LoginFeature
import javax.inject.Inject

class LaunchViewModel @Inject constructor(private val featureManager: FeatureManager) : ViewModel() {
    fun launchLoginFragment() = featureManager getFeature LoginFeature
}