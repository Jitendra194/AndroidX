package com.pills.createaccount.di.modules

import androidx.lifecycle.ViewModel
import com.pills.createaccount.views.EnterUserDetailsViewModel
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelProviderModule {
    @Binds
    @IntoMap
    @ViewModelKey(EnterUserDetailsViewModel::class)
    abstract fun bindUserDetailsViewModel(viewModel: EnterUserDetailsViewModel): ViewModel
}