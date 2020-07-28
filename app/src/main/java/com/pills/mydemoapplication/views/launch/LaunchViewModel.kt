package com.pills.mydemoapplication.views.launch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pills.mydemoapplication.feature_package.FeatureManager
import com.pills.mydemoapplication.feature_package.FeatureName.LoginFeature
import com.pills.mydemoapplication.feature_package.getFeature
import com.pills.mydemoapplication.repository.SessionManager
import kotlinx.coroutines.launch
import javax.inject.Inject

class LaunchViewModel @Inject constructor(
    private val featureManager: FeatureManager,
    private val sessionManager: SessionManager
) : ViewModel() {

    private val _accessTokenError = MutableLiveData<Boolean>()
    val accessTokenError: LiveData<Boolean>
        get() = _accessTokenError

    fun launchLoginFragment() = featureManager getFeature LoginFeature

    fun fetchAccessToken() = viewModelScope.launch {
        try {
            sessionManager.getAccessToken()
        } catch (e: Exception) {
            _accessTokenError.value = true
        }
    }
}