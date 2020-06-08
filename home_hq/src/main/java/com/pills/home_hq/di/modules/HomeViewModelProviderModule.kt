package com.pills.home_hq.di.modules

import androidx.lifecycle.ViewModel
import com.pills.home_hq.views.HomeViewModel
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class HomeViewModelProviderModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}