package com.pills.mydemoapplication.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.pills.mydemoapplication.R
import com.pills.mydemoapplication.databinding.HQActivityBinding
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import com.pills.mydemoapplication.nav_utils.navigate
import com.pills.mydemoapplication.nav_utils.setupNavDrawerDestination
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.h_q_activity.*
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
        setupActionBar()
        setupNavigationDrawer()
        setupBottomNavigationView()
    }

    private fun setupNavigationDrawer() {
        nav_view.setupWithNavController(navController)
        nav_view.setCheckedItem(R.id.drawer_home)
        nav_view.setNavigationItemSelectedListener { it.setupNavDrawerDestination() }
    }

    private fun setupActionBar() {
        setSupportActionBar(main_hq_toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun setupBottomNavigationView() {
        bottom_navigation.setupWithNavController(navController)
            .also { hqViewModel.launchPillsHub() }
        bottom_navigation.setOnNavigationItemSelectedListener {
            if (bottom_navigation.selectedItemId == it.itemId) false
            else hqViewModel.navigate(it, navController)
        }
    }

    override fun onSupportNavigateUp() =
        navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    override fun onBackPressed() {
        if (hq_drawer_layout.isDrawerOpen(GravityCompat.START)) {
            hq_drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
