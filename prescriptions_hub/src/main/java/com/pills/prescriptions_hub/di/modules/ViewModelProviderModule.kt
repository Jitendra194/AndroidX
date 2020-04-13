package com.pills.prescriptions_hub.di.modules

import androidx.lifecycle.ViewModel
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelKey
import com.pills.prescriptions_hub.views.PrescriptionsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelProviderModule {
    @Binds
    @IntoMap
    @ViewModelKey(PrescriptionsViewModel::class)
    abstract fun bindPrescriptionsViewModel(viewModel: PrescriptionsViewModel): ViewModel
}