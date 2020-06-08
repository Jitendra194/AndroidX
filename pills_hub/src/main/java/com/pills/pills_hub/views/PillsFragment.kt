package com.pills.pills_hub.views

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.transition.ArcMotion
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.transition.PathMotion
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import com.pills.mydemoapplication.utils.animation_utils.getEnterAnimation
import com.pills.mydemoapplication.utils.animation_utils.getExitAnimation
import com.pills.pills_hub.R
import com.pills.pills_hub.databinding.PillsFragmentBinding
import com.pills.pills_hub.featureImpl.pillsFeatureMainComponent
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postponeEnterTransition()
        sharedElementEnterTransition = MaterialContainerTransform().getEnterAnimation()
        sharedElementReturnTransition = MaterialContainerTransform().getExitAnimation()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<PillsFragmentBinding>(inflater, R.layout.pills_fragment, container, false).run {
        binding = this
        lifecycleOwner = viewLifecycleOwner
        root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.executePendingBindings()
        startPostponedEnterTransition()
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
