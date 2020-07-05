package com.pills.mydemoapplication.di.modules

import android.content.SharedPreferences
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.pills.mydemoapplication.base_application.BaseApplicationClass
import com.pills.mydemoapplication.feature_package.*
import com.pills.mydemoapplication.repository.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object FeaturesModule {

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
    fun providesHomeFeatureDependencies(application: BaseApplicationClass, featureManager: FeatureManager): HomeFeature.Dependencies {
        return object : HomeFeature.Dependencies {
            override val application: BaseApplicationClass
                get() = application
            override val featureManager: FeatureManager
                get() = featureManager
        }
    }

    @Provides
    @Singleton
    fun providesLoginFeatureDependencies(application: BaseApplicationClass,
                                         featureManager: FeatureManager,
                                         googleSignInClient: GoogleSignInClient,
                                         retrofit: Retrofit.Builder,
                                         roomDatabase: AppDatabase,
                                         sharedPreferences: SharedPreferences): LoginFeature.Dependencies {
        return object : LoginFeature.Dependencies {
            override val application: BaseApplicationClass
                get() = application
            override val featureManager: FeatureManager
                get() = featureManager
            override val googleSignInClient: GoogleSignInClient
                get() = googleSignInClient
            override val retrofit: Retrofit.Builder
                get() = retrofit
            override val appDatabase: AppDatabase
                get() = roomDatabase
            override val sharedPreferences: SharedPreferences
                get() = sharedPreferences
        }
    }
}