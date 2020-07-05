package com.pills.mydemoapplication.views.hq.bottom_nav_drawer

import android.content.SharedPreferences
import androidx.appcompat.app.AlertDialog
import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.pills.mydemoapplication.repository.SessionManager.Companion.AUTH_TOKEN
import com.pills.mydemoapplication.repository.SessionManager.Companion.IS_USER_LOGGED_IN
import com.pills.mydemoapplication.repository.local.database.AppDatabase
import com.pills.mydemoapplication.repository.local.entities.User
import com.pills.mydemoapplication.utils.extention_utils.debug
import kotlinx.coroutines.launch
import javax.inject.Inject

class BottomNavigationDrawerViewModel @Inject constructor(
    private val appDatabase: AppDatabase,
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    val user: LiveData<User> = appDatabase.userDao().getUser()

    private val _isUserLoggedOut = MutableLiveData<Boolean>(false)
    val isUserLoggedOut: LiveData<Boolean>
        get() = _isUserLoggedOut

    fun signOut(builder: MaterialAlertDialogBuilder): AlertDialog = builder.setTitle("Sign out?")
        .setPositiveButton("Yes") { _, _ -> processSignOut() }
        .setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
        .setCancelable(false)
        .show()

    private fun processSignOut() {
        viewModelScope.launch {
        try {
            appDatabase.userDao().deleteAll()
            sharedPreferences.edit {
                putString(AUTH_TOKEN, null)
                putBoolean(IS_USER_LOGGED_IN, false)
            }
            _isUserLoggedOut.value = true
        } catch (throwable: Throwable) {
            "error deleting user data".debug { throwable.message.toString() }
            _isUserLoggedOut.value = false
        }
    }}

}