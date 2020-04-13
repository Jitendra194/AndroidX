package com.pills.mydemoapplication.nav_utils

import android.util.Log
import android.view.MenuItem
import androidx.navigation.NavController
import com.pills.mydemoapplication.R
import com.pills.mydemoapplication.views.HQViewModel

internal fun HQViewModel.navigate(
    item: MenuItem,
    navController: NavController
): Boolean {
    try {
        if (item.itemId == navController.getBackStackEntry(item.itemId).destination.id) {
            navController.popBackStack(item.itemId, false)
            return true
        }
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }
    when (item.itemId) {
        R.id.pillsFragment -> launchPillsHub()
        R.id.labReportsFragment -> launchLabReportsHub()
        R.id.prescriptionsFragment -> launchMyPrescriptionsHub()
        R.id.wellnessTipsFragment -> launchWellnessTipsHub()
        else -> launchPillsHub()
    }
    navController.navigate(item.itemId)
    return true
}

internal fun MenuItem.setupNavDrawerDestination(): Boolean {
    when (this.itemId) {
        R.id.drawer_home -> Log.d("nav_drawer", this.title.toString())
        R.id.drawer_edit_profile -> Log.d("nav_drawer", this.title.toString())
        R.id.drawer_payment_methods -> Log.d("nav_drawer", this.title.toString())
        R.id.drawer_suggestion_box -> Log.d("nav_drawer", this.title.toString())
        R.id.drawer_help -> Log.d("nav_drawer", this.title.toString())
        R.id.drawer_sign_out -> Log.d("nav_drawer", this.title.toString())
        else -> Log.d("nav_drawer", this.title.toString())
    }
    return true
}