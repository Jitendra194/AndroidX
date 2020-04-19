package com.pills.mydemoapplication.di.modules

import com.pills.mydemoapplication.base_application.BaseApplicationClass
import com.pills.mydemoapplication.feature_package.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object FeaturesModule {

    @Provides
    @Singleton
    fun providesCreateAccountFeatureDependencies(application: BaseApplicationClass): AccountCreationFeature.Dependencies {
        return object : AccountCreationFeature.Dependencies {
            override val application: BaseApplicationClass
                get() = application
        }
    }

    @Provides
    @Singleton
    fun providesPillsFeatureDependencies(application: BaseApplicationClass): PillsFeature.Dependencies {
        return object : PillsFeature.Dependencies {
            override val application: BaseApplicationClass
                get() = application
        }
    }

    @Provides
    @Singleton
    fun providesLabReportsFeatureDependencies(application: BaseApplicationClass): LabReportsFeature.Dependencies {
        return object : LabReportsFeature.Dependencies {
            override val application: BaseApplicationClass
                get() = application
        }
    }

    @Provides
    @Singleton
    fun providesPrescriptionsFeatureDependencies(application: BaseApplicationClass): PrescriptionsFeature.Dependencies {
        return object : PrescriptionsFeature.Dependencies {
            override val application: BaseApplicationClass
                get() = application
        }
    }

    @Provides
    @Singleton
    fun providesWellnessTipsFeatureDependencies(application: BaseApplicationClass): WellnessTipsFeature.Dependencies {
        return object : WellnessTipsFeature.Dependencies {
            override val application: BaseApplicationClass
                get() = application
        }
    }

    @Provides
    @Singleton
    fun providesLoginFeatureDependencies(application: BaseApplicationClass, featureManager: FeatureManager): LoginFeature.Dependencies {
        return object : LoginFeature.Dependencies {
            override val application: BaseApplicationClass
                get() = application
            override val featureManager: FeatureManager
                get() = featureManager
        }
    }
}