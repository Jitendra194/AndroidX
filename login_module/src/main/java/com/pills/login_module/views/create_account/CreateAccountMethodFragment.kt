package com.pills.login_module.views.create_account

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
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.pills.login_module.R
import com.pills.login_module.databinding.FragmentCreateAccountMethodBinding
import com.pills.login_module.featureImpl.loginFeatureMainComponent
import com.pills.login_module.views.create_account.CreateAccountMethodViewModel.Companion.RC_SIGN_IN
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_create_account_method.*
import javax.inject.Inject

class CreateAccountMethodFragment : DaggerFragment() {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private val createAccountMethodViewModel: CreateAccountMethodViewModel by viewModels { viewModelProviderFactory }

    private lateinit var binding: FragmentCreateAccountMethodBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        loginFeatureMainComponent.createAccountComponent
            .create(this)
            .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        DataBindingUtil.inflate<FragmentCreateAccountMethodBinding>(inflater, R.layout.fragment_create_account_method, container, false).run {
        binding = this
        lifecycleOwner = viewLifecycleOwner
        viewModel = createAccountMethodViewModel
        binding.root
    }

    override fun onResume() {
        super.onResume()
        setUpUserActions()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            createAccountMethodViewModel.handleSignInResult(GoogleSignIn.getSignedInAccountFromIntent(data), {
                findNavController().navigate(CreateAccountMethodFragmentDirections.actionCreateAccountMethodFragmentToEnterUserDetailsFragment(it))
            }, {
                Toast.makeText(context, "Google Sign In Failed with Status Code: ${it?.statusCode}", Toast.LENGTH_SHORT).show()
            })
        }
    }

    private fun setUpUserActions() {
        sign_in_button.setOnClickListener {
            startActivityForResult(createAccountMethodViewModel.getGoogleSignInIntent(), RC_SIGN_IN)
        }
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
