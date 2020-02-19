package com.example.mydemoapplication.di.modules

import androidx.lifecycle.ViewModelProvider
import com.example.mydemoapplication.LoginViewModel_Factory
import com.example.mydemoapplication.base_application.BaseApplicationClass
import com.example.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import com.example.mydemoapplication.feature_package.FeatureManager
import com.example.mydemoapplication.feature_package.AccountCreationFeature
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Provides
    fun getString(): String {
        return "This is my String!"
    }

    @Provides
    @Singleton
    fun providesTestFeatureDependencies(application: BaseApplicationClass, string: String): AccountCreationFeature.Dependencies {
        return object : AccountCreationFeature.Dependencies {
            override val application: BaseApplicationClass
                get() = application
            override val string: String
                get() = string
        }
    }

    @Provides
    @Singleton
    fun providesFeatureManager(application: BaseApplicationClass): FeatureManager {
        return FeatureManager()
    }
}