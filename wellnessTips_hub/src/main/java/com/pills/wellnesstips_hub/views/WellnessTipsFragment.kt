package com.pills.wellnesstips_hub.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.google.android.material.transition.MaterialContainerTransform
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import com.pills.mydemoapplication.utils.animation_utils.getEnterAnimation
import com.pills.mydemoapplication.utils.animation_utils.getExitAnimation
import com.pills.wellnesstips_hub.R
import com.pills.wellnesstips_hub.databinding.WellnessTipsFragmentBinding
import com.pills.wellnesstips_hub.featureImpl.wellnessTipsFeatureMainComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class WellnessTipsFragment : Fragment(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var binding: WellnessTipsFragmentBinding

    private val viewModel: WellnessTipsViewModel by viewModels { viewModelProviderFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        wellnessTipsFeatureMainComponent.wellnessTipsFeatureComponent
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
    ): View? = DataBindingUtil.inflate<WellnessTipsFragmentBinding>(inflater, R.layout.wellness_tips_fragment, container, false).run {
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
