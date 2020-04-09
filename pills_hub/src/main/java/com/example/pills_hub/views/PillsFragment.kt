package com.example.pills_hub.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import com.example.pills_hub.R
import com.example.pills_hub.databinding.PillsFragmentBinding
import com.example.pills_hub.featureImpl.pillsFeatureMainComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class PillsFragment : Fragment(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var binding: PillsFragmentBinding

    private val viewModel: PillsViewModel by viewModels { viewModelProviderFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        pillsFeatureMainComponent.pillsFeatureComponent
            .create(this)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.pills_fragment, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
