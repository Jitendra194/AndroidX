package com.example.pills_hub.di.components

import com.example.pills_hub.views.PillsFragment
import com.example.pills_hub.di.modules.ViewModelProviderModule
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Subcomponent(
    modules = [AndroidInjectionModule::class,
        ViewModelProviderModule::class]
)
interface PillsFeatureComponent : AndroidInjector<PillsFragment> {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance pillsFragment: PillsFragment): PillsFeatureComponent
    }
}