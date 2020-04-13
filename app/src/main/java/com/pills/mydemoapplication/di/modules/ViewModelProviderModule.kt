package com.pills.mydemoapplication.di.modules

import androidx.lifecycle.ViewModel
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelKey
import com.pills.mydemoapplication.views.HQViewModel
import com.pills.mydemoapplication.views.LoginViewModel
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

    @Binds
    @IntoMap
    @ViewModelKey(HQViewModel::class)
    abstract fun bindHQViewModel(viewModel: HQViewModel): ViewModel
}