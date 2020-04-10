package com.example.mydemoapplication.nav_utils

import android.view.MenuItem
import androidx.navigation.NavController
import com.example.mydemoapplication.R
import com.example.mydemoapplication.views.HQViewModel

fun HQViewModel.navigate(
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