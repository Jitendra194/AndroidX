package com.pills.login_module.views.number_extra

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.pills.login_module.R
import com.pills.login_module.databinding.PhoneNumberExtraFragmentBinding
import com.pills.login_module.featureImpl.loginFeatureMainComponent
import com.pills.login_module.utils.State
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.phone_number_extra_fragment.*
import javax.inject.Inject

class PhoneNumberExtraFragment : Fragment(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var binding: PhoneNumberExtraFragmentBinding

    private val phoneNumberExtraViewModel: PhoneNumberExtraViewModel by viewModels { viewModelProviderFactory }
    private val args: PhoneNumberExtraFragmentArgs by navArgs()
    private val arrayAdapter: ArrayAdapter<String> by lazy { ArrayAdapter(requireContext(), R.layout.gender_item, listOf("Male", "Female")) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        loginFeatureMainComponent.phoneExtraUserDetailsComponent
            .create(this)
            .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        DataBindingUtil.inflate<PhoneNumberExtraFragmentBinding>(inflater, R.layout.phone_number_extra_fragment, container, false).run {
            binding = this
            viewModel = phoneNumberExtraViewModel
            lifecycleOwner = viewLifecycleOwner
            root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModelData()
        observeViewModel()
        setUpUserActions()
    }

    private fun setUpUserActions() = phoneNumberExtraViewModel.apply {
        phone_number_dob_field.setOnClickListener { getCalendar { it.show(childFragmentManager, it.toString()) } }
    }

    private fun setUpViewModelData() = phoneNumberExtraViewModel.apply {
        setArgsInViewModel(args.userDataRequestBody)
        phone_number_gender_field.setAdapter(arrayAdapter)
    }

    private fun observeViewModel() = phoneNumberExtraViewModel.apply {
        launch.observe(viewLifecycleOwner) { it?.let { setupLoginState(it) } }
    }

    private fun setupLoginState(state: State) = when(state) {
        State.SUCCESS -> registrationSuccess()
        State.FAILURE -> registrationFailure()
    }

    private fun registrationFailure() = Toast.makeText(context, "Failed to register!", Toast.LENGTH_SHORT).show()

    private fun registrationSuccess() {
        Toast.makeText(context, "Registration successful!", Toast.LENGTH_SHORT).show()
        findNavController().popBackStack(R.id.loginFragment, false)
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}