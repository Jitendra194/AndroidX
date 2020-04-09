package com.example.wellnesstips_hub.di.modules

import androidx.lifecycle.ViewModel
import com.example.mydemoapplication.di.viewmodel_factory.ViewModelKey
import com.example.wellnesstips_hub.views.WellnessTipsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelProviderModule {
    @Binds
    @IntoMap
    @ViewModelKey(WellnessTipsViewModel::class)
    abstract fun bindPrescriptionsViewModel(viewModel: WellnessTipsViewModel): ViewModel
}