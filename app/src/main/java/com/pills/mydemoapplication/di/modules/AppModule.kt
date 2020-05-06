package com.pills.mydemoapplication.di.modules

import com.pills.mydemoapplication.base_application.BaseApplicationClass
import com.pills.mydemoapplication.feature_package.FeatureManager
import com.pills.mydemoapplication.feature_package.FeatureManagerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {
    @Provides
    @Singleton
    fun providesFeatureManager(application: BaseApplicationClass): FeatureManager = FeatureManagerImpl(application)
}