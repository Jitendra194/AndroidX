package com.example.mydemoapplication.viewmodel_factory

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelProviderFactory @Inject constructor(creators: Map<Class<out ViewModel>, Provider<ViewModel>>)
    : ViewModelProvider.Factory {

    private companion object {
        val TAG: String = "ViewModelProviderFactory"
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

    }

}