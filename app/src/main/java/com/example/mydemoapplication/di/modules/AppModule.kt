package com.example.mydemoapplication.di.modules

import com.example.mydemoapplication.base_application.BaseApplicationClass
import com.example.mydemoapplication.feature_package.AccountCreationFeature
import com.example.mydemoapplication.feature_package.FeatureManager
import com.example.mydemoapplication.feature_package.LabReportsFeature
import com.example.mydemoapplication.feature_package.PillsFeature
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {
    @Provides
    @Singleton
    fun providesFeatureManager(application: BaseApplicationClass): FeatureManager {
        return FeatureManager()
    }
}