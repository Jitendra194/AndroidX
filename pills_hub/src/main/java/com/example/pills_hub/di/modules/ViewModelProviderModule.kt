package com.example.pills_hub.di.modules

import androidx.lifecycle.ViewModel
import com.example.mydemoapplication.di.viewmodel_factory.ViewModelKey
import com.example.pills_hub.views.PillsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelProviderModule {
    @Binds
    @IntoMap
    @ViewModelKey(PillsViewModel::class)
    abstract fun bindPillsViewModel(viewModel: PillsViewModel): ViewModel
}