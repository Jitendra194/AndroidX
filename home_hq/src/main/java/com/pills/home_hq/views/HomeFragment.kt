package com.pills.home_hq.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.pills.home_hq.R
import com.pills.home_hq.databinding.HomeFragmentBinding
import com.pills.home_hq.featureImpl.homeFeatureMainComponent
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.home_fragment.*
import javax.inject.Inject


class HomeFragment : Fragment(), HasAndroidInjector, FeatureRecyclerViewAdapter.FeatureItemClickListener {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var binding: HomeFragmentBinding

    private val homeViewModel: HomeViewModel by viewModels { viewModelProviderFactory }
    private val featureItemAdapter: FeatureRecyclerViewAdapter by lazy { FeatureRecyclerViewAdapter(getFeatureItems(), this) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        homeFeatureMainComponent.featureComponent
            .create(this)
            .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<HomeFragmentBinding>(inflater, R.layout.home_fragment, container, false).run {
        binding = this
        lifecycleOwner = viewLifecycleOwner
        viewModel = homeViewModel
        root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        binding.executePendingBindings()
        setupFeatureRecyclerView()
        view.doOnPreDraw { startPostponedEnterTransition() }
    }

    private fun setupFeatureRecyclerView() = feature_recycler_view.run {
        setHasFixedSize(true)
        overScrollMode = View.OVER_SCROLL_NEVER
        adapter = featureItemAdapter
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun onClickFeature(view: View, item: FeatureItem) {
        val extras = FragmentNavigatorExtras(view to view.transitionName)
        when (item.featureName) {
            FeatureItemTitle.OrderPills -> {
                homeViewModel.launchPillsHub()
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPillsFragment(), extras)
            }
            FeatureItemTitle.LabReports -> {
                homeViewModel.launchLabReportsHub()
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLabReportsFragment(), extras)
            }
            FeatureItemTitle.Prescriptions -> {
                homeViewModel.launchMyPrescriptionsHub()
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPrescriptionsFragment(), extras)
            }
            FeatureItemTitle.WellnessTips -> {
                homeViewModel.launchWellnessTipsHub()
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToWellnessTipsFragment(), extras)
            }
        }
    }
}