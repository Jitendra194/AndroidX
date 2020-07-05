package com.pills.mydemoapplication.di.modules

import com.pills.mydemoapplication.di.viewmodel_providers.BottomNavigationDrawerViewModelProviderModule
import com.pills.mydemoapplication.views.hq.bottom_nav_drawer.BottomNavigationDrawerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = [BottomNavigationDrawerViewModelProviderModule::class])
    abstract fun contributesBottomNavigationDrawerFragment(): BottomNavigationDrawerFragment
}