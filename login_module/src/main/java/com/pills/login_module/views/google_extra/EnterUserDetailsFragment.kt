package com.pills.login_module.views.google_extra

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.pills.login_module.R
import com.pills.login_module.databinding.FragmentEnterUserDetailsBinding
import com.pills.login_module.featureImpl.loginFeatureMainComponent
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.fragment_enter_user_details.*
import javax.inject.Inject

class EnterUserDetailsFragment : Fragment(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var binding: FragmentEnterUserDetailsBinding

    private val userDetailsViewModel: EnterUserDetailsViewModel by viewModels { viewModelProviderFactory }
    private val args: EnterUserDetailsFragmentArgs by navArgs()
    private val arrayAdapter: ArrayAdapter<String> by lazy { ArrayAdapter(requireContext(), R.layout.gender_item, listOf("Male", "Female")) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        loginFeatureMainComponent.googleUserDetailsComponent
            .create(this)
            .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        DataBindingUtil.inflate<FragmentEnterUserDetailsBinding>(inflater, R.layout.fragment_enter_user_details, container, false).run {
            binding = this
            viewModel = userDetailsViewModel
            lifecycleOwner = viewLifecycleOwner
            root
    }

    override fun onStart() {
        super.onStart()
        userDetailsViewModel.apply {
            setArgsInViewModel(args.GivenName)
            enter_details_gender_field.setAdapter(arrayAdapter)
            enter_details_dob_field.setOnClickListener { getCalendar { it.show(childFragmentManager, it.toString()) } }
        }
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
