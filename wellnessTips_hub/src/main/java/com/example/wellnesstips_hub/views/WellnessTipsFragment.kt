package com.example.wellnesstips_hub.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import com.example.wellnesstips_hub.R
import com.example.wellnesstips_hub.featureImpl.wellnessTipsFeatureMainComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class WellnessTipsFragment : Fragment(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private val viewModel: WellnessTipsViewModel by viewModels { viewModelProviderFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        wellnessTipsFeatureMainComponent.wellnessTipsFeatureComponent
            .create(this)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.wellness_tips_fragment, container, false)
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
