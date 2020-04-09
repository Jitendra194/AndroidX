package com.example.wellnesstips_hub.di.components

import com.example.wellnesstips_hub.di.modules.ViewModelProviderModule
import com.example.wellnesstips_hub.views.WellnessTipsFragment
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Subcomponent(
    modules = [ViewModelProviderModule::class,
        AndroidInjectionModule::class]
)
interface WellnessTipsFeatureComponent : AndroidInjector<WellnessTipsFragment> {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance wellnessTipsFragment: WellnessTipsFragment): WellnessTipsFeatureComponent
    }
}