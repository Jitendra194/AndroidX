package com.pills.createaccount.views

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class EnterUserDetailsViewModel @Inject constructor() : ViewModel() {
    private val finishActivityEvent = MutableLiveData<Boolean>(false)
    val finishActivity: LiveData<Boolean>
        get() = finishActivityEvent

    fun onClickNext(view: View) {
        finishActivityEvent.postValue(true)
    }
}