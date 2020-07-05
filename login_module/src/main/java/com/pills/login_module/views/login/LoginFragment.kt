package com.pills.login_module.views.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.pills.login_module.R
import com.pills.login_module.databinding.LoginFragmentBinding
import com.pills.login_module.featureImpl.loginFeatureMainComponent
import com.pills.login_module.utils.State
import com.pills.login_module.utils.State.*
import com.pills.login_module.utils.RC_SIGN_IN
import com.pills.login_module.utils.handleSignInResult
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

    private val loginViewModel: LoginViewModel by viewModels { viewModelProviderFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        loginFeatureMainComponent.loginComponent
            .create(this)
            .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<LoginFragmentBinding>(inflater, R.layout.login_fragment, container, false).run {
        binding = this
        viewModel = loginViewModel
        lifecycleOwner = viewLifecycleOwner
        root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        setupButtonLaunchEvents()
    }

    private fun observeViewModel() = loginViewModel.apply {
        launch.observe(viewLifecycleOwner) { it?.let { setupLoginState(it) } }
    }

    private fun setupLoginState(state: State) = when(state) {
        SUCCESS -> loginSuccess()
        FAILURE -> loginFailure()
    }

    private fun loginFailure() = Toast.makeText(context, "Failed to login!", Toast.LENGTH_SHORT).show()

    private fun loginSuccess() {
        startActivity(loginViewModel.launchHQ())
        activity?.finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            GoogleSignIn.getSignedInAccountFromIntent(data).handleSignInResult({
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToEnterUserDetailsFragment(it))
            }, {
                Toast.makeText(context, "Google Sign In Failed with Status Code: ${it?.statusCode}", Toast.LENGTH_SHORT).show()
            })
        }
    }

    private fun setupButtonLaunchEvents() {
        launch_create_account.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToCreateAccountMethodFragment())
        }
        sign_in_button.setOnClickListener {
            startActivityForResult(loginViewModel.getGoogleSignInIntent(), RC_SIGN_IN)
        }
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
