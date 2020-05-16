package com.pills.mydemoapplication.di.viewmodel_factory

import androidx.lifecycle.ViewModelProvider
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Suppress("unused")
@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}