package com.pills.home_hq.di.components

import com.pills.home_hq.di.modules.HomeViewModelProviderModule
import com.pills.home_hq.views.HomeFragment
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Subcomponent(modules = [AndroidInjectionModule::class, HomeViewModelProviderModule::class])
interface FeatureComponent : AndroidInjector<HomeFragment> {
    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance homeFragment: HomeFragment): FeatureComponent
    }
}