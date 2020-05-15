package com.pills.login_module.views.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.pills.login_module.R
import com.pills.login_module.databinding.LoginFragmentBinding
import com.pills.login_module.featureImpl.loginFeatureMainComponent
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class LoginFragment : Fragment(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var binding: LoginFragmentBinding

    private val viewModel: LoginViewModel by viewModels { viewModelProviderFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        loginFeatureMainComponent.loginComponent
            .create(this)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        binding.lifecycleOwner = this
        setupButtonLaunchEvents()
        return binding.root
    }

    private fun setupButtonLaunchEvents() {
        binding.launchCreateAccount.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToCreateAccountMethodFragment())
        }
        binding.loginButton.setOnClickListener { startActivity(viewModel.launchHQ()) }
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
