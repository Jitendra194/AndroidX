package com.pills.createaccount.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.pills.createaccount.databinding.FragmentEnterUserDetailsBinding
import com.pills.createaccount.views.EnterUserDetailsViewModel
import com.pills.createaccount.R
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class EnterUserDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var binding: FragmentEnterUserDetailsBinding

    private val userDetailsViewModel: EnterUserDetailsViewModel by viewModels<EnterUserDetailsViewModel> { viewModelProviderFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
