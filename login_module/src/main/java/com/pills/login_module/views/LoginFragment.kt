package com.pills.login_module.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.pills.login_module.R
import com.pills.login_module.databinding.LoginFragmentBinding
import com.pills.login_module.featureImpl.loginFeatureMainComponent
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.login_fragment.*
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
        loginFeatureMainComponent.loginFeatureComponent
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
        binding.launchCreateAccount.setOnClickListener { getCreateAccountScreen() }
        binding.loginButton.setOnClickListener { startActivity(viewModel.launchHQ()) }
        viewModel.isFeatureEventTriggered.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, "$it is installed successfully", Toast.LENGTH_SHORT).show()
            getCreateAccountScreen()
        })
    }

    private fun getCreateAccountScreen() {
        if (viewModel.isCreateAccountFeatureInstalled()) {
            startActivity(viewModel.launchSignupScreen())
        } else {
            viewModel.installCreateAccountFeature()
        }
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
