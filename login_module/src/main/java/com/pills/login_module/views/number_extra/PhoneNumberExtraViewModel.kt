package com.pills.login_module.views.number_extra

import androidx.lifecycle.*
import com.google.android.material.datepicker.MaterialDatePicker
import com.pills.login_module.repository.LoginRepository
import com.pills.login_module.repository.models.UserDataRequest
import com.pills.login_module.utils.State
import com.pills.login_module.utils.convertToDateString
import com.pills.login_module.utils.setupDOBCalendar
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhoneNumberExtraViewModel @Inject constructor(private val repository: LoginRepository) : ViewModel() {

    private lateinit var userDataRequest: UserDataRequest

    private val _dobField = MutableLiveData<String>()
    val dobField: LiveData<String>
        get() = _dobField

    private val _genderField = MutableLiveData<String>()
    val genderField: LiveData<String>
        get() = _genderField

    private val _firstName = MutableLiveData<String>()
    val firstName: LiveData<String>
        get() = _firstName

    val submit = MediatorLiveData<Boolean>().apply {
        addSource(genderField) { value = setRemainingData() }
        addSource(dobField) { value = setRemainingData() }
    }

    private val _launchLogin = MutableLiveData<State?>(null)
    val launch: LiveData<State?>
        get() = _launchLogin

    fun getCalendar(showPicker: (MaterialDatePicker<Long>) -> Unit): MaterialDatePicker<Long> {
        return (MaterialDatePicker.Builder.datePicker()).setupDOBCalendar().apply {
            showPicker(this)
            addOnPositiveButtonClickListener { _dobField.value = it.convertToDateString() }
        }
    }

    fun setArgsInViewModel(userDataRequest: UserDataRequest) {
        this.userDataRequest = userDataRequest
        _firstName.value = userDataRequest.fName
    }

    fun submit() {
        viewModelScope.launch {
            try {
                repository.sendUserData(userDataRequest)
                _launchLogin.value = State.SUCCESS
            } catch (e: Throwable) {
                e.printStackTrace()
                _launchLogin.value = State.FAILURE
            }
        }
    }

    fun onGenderTextChanged(s: CharSequence) {
        _genderField.value = s.toString()
    }

    private fun setRemainingData(): Boolean = if (genderField.value != null && dobField.value != null) {
        userDataRequest.gender = genderField.value
        userDataRequest.DOB = dobField.value
        true
    } else {
        false
    }
}