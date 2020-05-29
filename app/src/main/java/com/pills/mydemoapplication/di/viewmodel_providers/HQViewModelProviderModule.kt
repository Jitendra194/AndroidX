package com.pills.mydemoapplication.di.viewmodel_providers

import androidx.lifecycle.ViewModel
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelKey
import com.pills.mydemoapplication.views.hq.HQViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class HQViewModelProviderModule {
    @Binds
    @IntoMap
    @ViewModelKey(HQViewModel::class)
    abstract fun bindHQViewModel(viewModel: HQViewModel): ViewModel
}