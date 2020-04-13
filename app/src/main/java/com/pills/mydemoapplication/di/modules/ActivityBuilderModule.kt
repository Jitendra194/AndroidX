package com.pills.mydemoapplication.di.modules

import com.pills.mydemoapplication.views.HQActivity
import com.pills.mydemoapplication.views.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [ViewModelProviderModule::class])
    abstract fun contributesMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [ViewModelProviderModule::class])
    abstract fun contributesHQActivity(): HQActivity
}