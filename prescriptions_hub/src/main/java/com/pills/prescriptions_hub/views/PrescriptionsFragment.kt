package com.pills.prescriptions_hub.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.pills.prescriptions_hub.databinding.PrescriptionsFragmentBinding
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import com.pills.prescriptions_hub.R
import com.pills.prescriptions_hub.featureImpl.prescriptionsFeatureMainComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class PrescriptionsFragment : Fragment(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var binding: PrescriptionsFragmentBinding

    private val viewModel: PrescriptionsViewModel by viewModels { viewModelProviderFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        prescriptionsFeatureMainComponent.prescriptionsFeatureComponent
            .create(this)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.prescriptions_fragment, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
