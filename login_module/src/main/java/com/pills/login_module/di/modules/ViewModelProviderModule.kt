package com.pills.login_module.di.modules

import androidx.lifecycle.ViewModel
import com.pills.login_module.views.LoginViewModel
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelProviderModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel
}