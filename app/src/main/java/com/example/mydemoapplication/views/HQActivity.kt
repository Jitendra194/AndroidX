package com.example.mydemoapplication.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mydemoapplication.R
import com.example.mydemoapplication.databinding.HQActivityBinding
import com.example.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class HQActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var binding: HQActivityBinding

    private val hqViewModel: HQViewModel by viewModels { viewModelProviderFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.h_q_activity)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navController = findNavController(R.id.main_hq_navigation)
        binding.bottomNavigation.setupWithNavController(navController)
            .also { hqViewModel.initialize() }

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.pillsFragment -> {
                    hqViewModel.initialize()
                    navController.navigate(R.id.pillsFragment)
                }
                R.id.labReportsFragment -> {
                    hqViewModel.launchLabReports()
                    navController.navigate(R.id.labReportsFragment)
                }
                R.id.prescriptionsFragment -> {
                    hqViewModel.launchMyPrescriptions()
                    navController.navigate(R.id.prescriptionsFragment)
                }
                R.id.wellnessTipsFragment -> {
                    hqViewModel.launchWellnessTips()
                    navController.navigate(R.id.wellnessTipsFragment)
                }
            }
            true
        }
    }

    override fun onSupportNavigateUp() = findNavController(R.id.main_hq_navigation).navigateUp()
}
