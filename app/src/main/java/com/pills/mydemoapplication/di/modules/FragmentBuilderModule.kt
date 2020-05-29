package com.pills.mydemoapplication.di.modules

import com.pills.mydemoapplication.di.viewmodel_providers.HomeViewModelProviderModule
import com.pills.mydemoapplication.views.hq.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = [HomeViewModelProviderModule::class])
    abstract fun contributesHomeFragment(): HomeFragment
}