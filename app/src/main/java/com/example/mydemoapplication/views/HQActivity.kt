package com.example.mydemoapplication.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mydemoapplication.R
import com.example.mydemoapplication.databinding.HQActivityBinding
import com.example.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import com.example.mydemoapplication.nav_utils.NavigationUtil
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class HQActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var binding: HQActivityBinding

    private val hqViewModel: HQViewModel by viewModels { viewModelProviderFactory }
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.h_q_activity)
        navController = findNavController(R.id.main_hq_navigation)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.pillsFragment,
                R.id.labReportsFragment,
                R.id.prescriptionsFragment,
                R.id.wellnessTipsFragment
            ), binding.hqDrawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
        setupNavigation()
    }

    private fun setupNavigation() {
        binding.bottomNavigation.setupWithNavController(navController)
            .also { hqViewModel.launchPillsHub() }

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            NavigationUtil.navigate(it, hqViewModel, navController)
        }
    }

    override fun onSupportNavigateUp() = navController.navigateUp(appBarConfiguration)

    override fun onBackPressed() {
        super.onBackPressed()
        navController.popBackStack(R.id.pillsFragment, false)
    }
}
