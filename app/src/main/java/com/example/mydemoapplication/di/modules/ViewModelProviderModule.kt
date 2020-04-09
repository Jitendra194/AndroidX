package com.example.mydemoapplication.di.modules

import androidx.lifecycle.ViewModel
import com.example.mydemoapplication.views.LoginViewModel
import com.example.mydemoapplication.di.viewmodel_factory.ViewModelKey
import com.example.mydemoapplication.views.HQViewModel
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