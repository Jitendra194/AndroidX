package com.pills.wellnesstips_hub.di.modules

import androidx.lifecycle.ViewModel
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelKey
import com.pills.wellnesstips_hub.views.WellnessTipsViewModel
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