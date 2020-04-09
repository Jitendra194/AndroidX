package com.example.lab_hub.di.modules

import androidx.lifecycle.ViewModel
import com.example.lab_hub.views.LabReportsViewModel
import com.example.mydemoapplication.di.viewmodel_factory.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelProviderModule {
    @Binds
    @IntoMap
    @ViewModelKey(LabReportsViewModel::class)
    abstract fun bindLabReportsViewModel(viewModel: LabReportsViewModel): ViewModel
}