package com.pills.createaccount.views

import androidx.databinding.ObservableBoolean
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
    val mobileField = ObservableField<String>()
    val genderField = ObservableField<String>()
    val nameInTitle = ObservableField<String>()

    val mobileError = ObservableBoolean(false)
    val dobError = ObservableBoolean(false)
    val genderError = ObservableBoolean(false)

    private val _buttonState = MutableLiveData(false)
    val buttonState: LiveData<Boolean>
        get() = _buttonState.apply {
            value = !dobField.get().isNullOrBlank() && !mobileField.get().isNullOrBlank() && !genderField.get().isNullOrBlank()
        }

    inline fun getCalendar(showPicker: (MaterialDatePicker<Long>) -> Unit): MaterialDatePicker<Long> =
        (MaterialDatePicker.Builder.datePicker()).setupDOBCalendar().apply {
            showPicker(this)
            addOnPositiveButtonClickListener { dobField.set(it.convertToDateString()) }
        }

    fun onMobileTextChanged(s: CharSequence) = mobileError.set(s.contains(" ") || s.length < 10)

    fun onGenderTextChanged(s: CharSequence) = genderError.set(s.isBlank())

    fun onDobTextChanged(s: CharSequence) = dobError.set(s.isBlank())

    fun setArgsInViewModel(name: String): Unit = nameInTitle.set(name)
}