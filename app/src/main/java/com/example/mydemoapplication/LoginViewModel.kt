package com.example.mydemoapplication

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor() : ViewModel() {
    fun test(printText: String) = printText
}