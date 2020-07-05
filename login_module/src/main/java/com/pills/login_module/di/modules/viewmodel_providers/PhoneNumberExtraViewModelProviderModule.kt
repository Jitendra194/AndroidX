package com.pills.login_module.di.modules.viewmodel_providers

import androidx.lifecycle.ViewModel
import com.pills.login_module.views.create_account.CreateAccountMethodViewModel
import com.pills.login_module.views.google_extra.EnterUserDetailsViewModel
import com.pills.login_module.views.login.LoginViewModel
import com.pills.login_module.views.number_extra.PhoneNumberExtraViewModel
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class PhoneNumberExtraViewModelProviderModule {
    @Binds
    @IntoMap
    @ViewModelKey(PhoneNumberExtraViewModel::class)
    abstract fun bindEnterUserDetailsViewModel(viewModel: PhoneNumberExtraViewModel): ViewModel
}