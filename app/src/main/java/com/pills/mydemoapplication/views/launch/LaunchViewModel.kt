package com.pills.mydemoapplication.views.launch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pills.mydemoapplication.feature_package.FeatureManager
import com.pills.mydemoapplication.feature_package.FeatureName.LoginFeature
import com.pills.mydemoapplication.feature_package.getFeature
import com.pills.mydemoapplication.repository.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LaunchViewModel @Inject constructor(
    private val featureManager: FeatureManager,
    private val sessionManager: SessionManager
) : ViewModel() {
    fun launchLoginFragment() = featureManager getFeature LoginFeature

    fun fetchAccessToken() = viewModelScope.launch { sessionManager.getAccessToken() }
}