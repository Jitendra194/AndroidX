package com.pills.mydemoapplication.di.viewmodel_providers

import androidx.lifecycle.ViewModel
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelKey
import com.pills.mydemoapplication.views.launch.LaunchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class LaunchViewModelProviderModule {
    @Binds
    @IntoMap
    @ViewModelKey(LaunchViewModel::class)
    abstract fun bindLaunchViewModel(viewModel: LaunchViewModel): ViewModel
}