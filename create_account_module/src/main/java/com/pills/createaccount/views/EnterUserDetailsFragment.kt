package com.pills.createaccount.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.pills.createaccount.R
import com.pills.createaccount.databinding.FragmentEnterUserDetailsBinding
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_enter_user_details.*
import javax.inject.Inject

class EnterUserDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var binding: FragmentEnterUserDetailsBinding

    private val userDetailsViewModel: EnterUserDetailsViewModel by viewModels { viewModelProviderFactory }
    private val args: EnterUserDetailsFragmentArgs by navArgs()
    private val arrayAdapter: ArrayAdapter<String> by lazy { ArrayAdapter(requireContext(), R.layout.gender_item, listOf("Male", "Female")) }

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
            pageData.observe(viewLifecycleOwner, Observer { Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show() })
            enter_details_dob_field.setOnClickListener { getCalendar { it.show(childFragmentManager, it.toString()) } }
            enter_details_gender_field.setAdapter(arrayAdapter)
        }
    }
}
