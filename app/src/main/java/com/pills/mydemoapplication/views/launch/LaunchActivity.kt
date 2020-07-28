package com.pills.mydemoapplication.views.launch

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.pills.mydemoapplication.R
import com.pills.mydemoapplication.databinding.LaunchActivityBinding
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class LaunchActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var binding: LaunchActivityBinding

    private val viewModel: LaunchViewModel by viewModels { viewModelProviderFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.launch_activity)
        viewModel.accessTokenError.observe(this) {
            if (it) Toast.makeText(this, "Error fetching access token!", Toast.LENGTH_SHORT).show()
        }
        viewModel.launchLoginFragment()
        viewModel.fetchAccessToken()
    }
}
