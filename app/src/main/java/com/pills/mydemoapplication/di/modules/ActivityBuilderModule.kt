package com.pills.mydemoapplication.di.modules

import com.pills.mydemoapplication.di.viewmodel_providers.HQViewModelProviderModule
import com.pills.mydemoapplication.di.viewmodel_providers.LaunchViewModelProviderModule
import com.pills.mydemoapplication.views.hq.HQActivity
import com.pills.mydemoapplication.views.launch.LaunchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [LaunchViewModelProviderModule::class])
    abstract fun contributesLaunchActivity(): LaunchActivity

    @ContributesAndroidInjector(modules = [HQViewModelProviderModule::class, FragmentBuilderModule::class])
    abstract fun contributesHQActivity(): HQActivity
}