package com.example.mydemoapplication.nav_utils

import android.view.MenuItem
import androidx.navigation.NavController
import com.example.mydemoapplication.R
import com.example.mydemoapplication.views.HQViewModel

class NavigationUtil {
    companion object {
        fun navigate(
            item: MenuItem,
            hqViewModel: HQViewModel,
            navController: NavController
        ): Boolean {
            when (item.itemId) {
                R.id.pillsFragment -> {
                    hqViewModel.launchPillsHub()
                    navController.navigate(R.id.pillsFragment)
                }
                R.id.labReportsFragment -> {
                    hqViewModel.launchLabReportsHub()
                    navController.navigate(R.id.labReportsFragment)
                }
                R.id.prescriptionsFragment -> {
                    hqViewModel.launchMyPrescriptionsHub()
                    navController.navigate(R.id.prescriptionsFragment)
                }
                R.id.wellnessTipsFragment -> {
                    hqViewModel.launchWellnessTipsHub()
                    navController.navigate(R.id.wellnessTipsFragment)
                }
                else -> {
                    hqViewModel.launchPillsHub()
                    navController.navigate(R.id.pillsFragment)
                }
            }
            return true
        }
    }
}