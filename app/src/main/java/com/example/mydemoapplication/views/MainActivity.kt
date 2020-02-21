package com.example.mydemoapplication.views

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mydemoapplication.R
import com.example.mydemoapplication.databinding.ActivityMainBinding
import com.example.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[LoginViewModel::class.java]

        binding.launchCreateAccount.setOnClickListener {
            startActivity(viewModel.test())
        }
    }
}
