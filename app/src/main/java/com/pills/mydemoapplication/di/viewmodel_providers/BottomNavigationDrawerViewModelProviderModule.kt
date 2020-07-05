package com.pills.mydemoapplication.di.viewmodel_providers

import androidx.lifecycle.ViewModel
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelKey
import com.pills.mydemoapplication.views.hq.HQViewModel
import com.pills.mydemoapplication.views.hq.bottom_nav_drawer.BottomNavigationDrawerViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class BottomNavigationDrawerViewModelProviderModule {
    @Binds
    @IntoMap
    @ViewModelKey(BottomNavigationDrawerViewModel::class)
    abstract fun bindHQViewModel(viewModel: BottomNavigationDrawerViewModel): ViewModel
}