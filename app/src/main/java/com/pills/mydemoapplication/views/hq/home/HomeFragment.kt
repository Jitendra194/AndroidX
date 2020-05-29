package com.pills.mydemoapplication.views.hq.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels

import com.pills.mydemoapplication.R
import com.pills.mydemoapplication.databinding.HomeFragmentBinding
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var binding: HomeFragmentBinding

    private val homeViewModel: HomeViewModel by viewModels { viewModelProviderFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<HomeFragmentBinding>(inflater, R.layout.home_fragment, container, false).run {
        binding = this
        lifecycleOwner = viewLifecycleOwner
        viewModel = homeViewModel
        root
    }
}
