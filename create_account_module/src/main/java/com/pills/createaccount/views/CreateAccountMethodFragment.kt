package com.pills.createaccount.views

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.pills.createaccount.R
import com.pills.createaccount.databinding.CreateAccountMethodFragmentBinding
import com.pills.createaccount.views.CreateAccountMethodViewModel.Companion.RC_SIGN_IN
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.create_account_method_fragment.*
import javax.inject.Inject

class CreateAccountMethodFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private val createAccountMethodViewModel: CreateAccountMethodViewModel by viewModels { viewModelProviderFactory }

    private lateinit var binding: CreateAccountMethodFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        DataBindingUtil.inflate<CreateAccountMethodFragmentBinding>(inflater, R.layout.create_account_method_fragment, container, false).run {
        binding = this
        lifecycleOwner = this@CreateAccountMethodFragment
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
        /*create_account_method_next_button.setOnClickListener {
            findNavController().navigate(CreateAccountMethodFragmentDirections.actionCreateAccountMethodFragmentToEnterUserDetailsFragment())
        }*/
        sign_in_button.setOnClickListener {
            startActivityForResult(createAccountMethodViewModel.getGoogleSignInIntent(), RC_SIGN_IN)
        }
    }
}
