package com.example.createaccount.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.createaccount.R
import com.example.createaccount.databinding.FragmentEnterUserDetailsBinding
import com.example.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class EnterUserDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var userDetailsViewModel: EnterUserDetailsViewModel
    private lateinit var binding: FragmentEnterUserDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userDetailsViewModel =
            ViewModelProvider(this, viewModelProviderFactory)[EnterUserDetailsViewModel::class.java]
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_enter_user_details,
            container,
            false
        )

        userDetailsViewModel.finishActivity.observe(this) { if (it) activity?.finish() }

        return binding.run {
            viewModel = userDetailsViewModel
            lifecycleOwner = this@EnterUserDetailsFragment
            root
        }
    }
}
