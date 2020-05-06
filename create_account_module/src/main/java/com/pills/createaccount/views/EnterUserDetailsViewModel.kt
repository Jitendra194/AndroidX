package com.pills.createaccount.views

import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import com.pills.createaccount.utils.convertToDateString
import com.pills.createaccount.utils.setupDOBCalendar
import javax.inject.Inject

class EnterUserDetailsViewModel @Inject constructor() : ViewModel() {

    val dobField = ObservableField<String>()
    val mobileNumber = ObservableField<String>()
    val gender = ObservableField<String>()
    val nameInTitle = ObservableField<String>()

    private val _pageData = MutableLiveData<List<String?>>()
    val pageData: LiveData<List<String?>>
        get() = _pageData

    fun onClickSubmit(view: View) {
        _pageData.value = listOf(nameInTitle.get(), dobField.get(), mobileNumber.get(), gender.get())
    }

    fun getCalendar(showPicker: (MaterialDatePicker<Long>) -> Unit): MaterialDatePicker<Long> =
        (MaterialDatePicker.Builder.datePicker()).setupDOBCalendar().apply {
            showPicker(this)
            addOnPositiveButtonClickListener { dobField.set(it.convertToDateString()) }
        }

    fun setArgsInViewModel(name: String): Unit = nameInTitle.set(name)
}