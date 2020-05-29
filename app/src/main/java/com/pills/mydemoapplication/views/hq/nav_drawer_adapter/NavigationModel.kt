package com.pills.mydemoapplication.views.hq.nav_drawer_adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pills.mydemoapplication.R
import com.pills.mydemoapplication.views.hq.nav_drawer_adapter.NavigationModelItem.Companion.EDIT_PROFILE
import com.pills.mydemoapplication.views.hq.nav_drawer_adapter.NavigationModelItem.Companion.FEEDBACK
import com.pills.mydemoapplication.views.hq.nav_drawer_adapter.NavigationModelItem.Companion.HELP
import com.pills.mydemoapplication.views.hq.nav_drawer_adapter.NavigationModelItem.Companion.HOME
import com.pills.mydemoapplication.views.hq.nav_drawer_adapter.NavigationModelItem.Companion.PAYMENT_METHOD

object NavigationModel {
    private val _navigationList: MutableLiveData<List<NavigationModelItem>> = MutableLiveData()
    val navigationList: LiveData<List<NavigationModelItem>>
        get() = _navigationList

    private var mainNavMenuItems = mutableListOf(
        NavigationModelItem.NavMenuItem(
            id = HOME,
            icon = R.drawable.ic_home,
            titleRes = R.string.home,
            checked = false
        ),
        NavigationModelItem.NavMenuItem(
            id = EDIT_PROFILE,
            icon = R.drawable.ic_edit_profile,
            titleRes = R.string.edit_profile,
            checked = false
        ),
        NavigationModelItem.NavMenuItem(
            id = PAYMENT_METHOD,
            icon = R.drawable.ic_payment_method,
            titleRes = R.string.payment_method,
            checked = false
        ),
        NavigationModelItem.NavMenuItem(
            id = FEEDBACK,
            icon = R.drawable.ic_feedback,
            titleRes = R.string.suggestion_box,
            checked = false
        ),
        NavigationModelItem.NavMenuItem(
            id = HELP,
            icon = R.drawable.ic_help,
            titleRes = R.string.help,
            checked = false
        )
    )

    private var signOutItem = mutableListOf(
        NavigationModelItem.NavSignOutItem(
            id = 0,
            icon = R.drawable.ic_sign_out,
            titleRes = R.string.sign_out
        )
    )

    init {
        postListUpdate()
    }

    fun setNavigationMenuItemChecked(id: Int, isChecked: Boolean): Boolean {
        if (!isChecked) {
            mainNavMenuItems.forEachIndexed { index, navMenuItem ->
                mainNavMenuItems[index] = navMenuItem.copy(checked = id == navMenuItem.id)
            }
            postListUpdate()
            return true
        }
        return false
    }

    private fun postListUpdate() = (mainNavMenuItems.subList(0, 3) +
            (NavigationModelItem.NavDivider("Help and feedback")) +
            mainNavMenuItems.subList(3, 5) +
            (NavigationModelItem.NavDivider(null)) +
            signOutItem).also { _navigationList.value = it }
}