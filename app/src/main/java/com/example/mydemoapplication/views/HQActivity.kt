package com.example.mydemoapplication.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
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

    private val navController by lazy { findNavController(R.id.main_hq_navigation) }
    private val hqViewModel: HQViewModel by viewModels { viewModelProviderFactory }
    private val appBarConfiguration by lazy {
        AppBarConfiguration(
            setOf(
                R.id.pillsFragment,
                R.id.labReportsFragment,
                R.id.prescriptionsFragment,
                R.id.wellnessTipsFragment
            ), binding.hqDrawerLayout
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.h_q_activity)
        setSupportActionBar(binding.mainHqToolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        NavigationUI.setupWithNavController(
            binding.mainHqToolbar,
            navController,
            appBarConfiguration
        )
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

    override fun onSupportNavigateUp() =
        navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    override fun onBackPressed() {
        if (binding.hqDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.hqDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
            navController.popBackStack(R.id.pillsFragment, false)
        }
    }
}
