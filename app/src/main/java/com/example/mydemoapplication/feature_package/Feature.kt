package com.example.mydemoapplication.feature_package

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import com.example.mydemoapplication.R
import com.example.mydemoapplication.base_application.BaseApplicationClass
import com.example.mydemoapplication.di.modules.ViewModelFactoryModule
import com.example.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import kotlin.reflect.KClass

fun <T : Feature<*>> KClass<T>.info(context: Context) = when (this) {
    AccountCreationFeature::class -> Feature.Info(
        id = "home",
        name = context.getString(R.string.create_account)
    )
    else -> throw IllegalArgumentException("Unexpected feature $this")
}

interface Feature<T> {
    fun getLaunchIntent(context: Context): Intent
    fun inject(dependencies: T)

    data class Info(
        val id: String,
        val name: String
    )
}

interface AccountCreationFeature : Feature<AccountCreationFeature.Dependencies> {
    interface Dependencies {
        val application: BaseApplicationClass
    }
}

interface PillsFeature : Feature<PillsFeature.Dependencies> {
    interface Dependencies {
        val application: BaseApplicationClass
    }
}

interface LabReportsFeature : Feature<LabReportsFeature.Dependencies> {
    interface Dependencies {
        val application: BaseApplicationClass
    }
}

interface PrescriptionsFeature : Feature<PrescriptionsFeature.Dependencies> {
    interface Dependencies {
        val application: BaseApplicationClass
    }
}

interface WellnessTipsFeature : Feature<WellnessTipsFeature.Dependencies> {
    interface Dependencies {
        val application: BaseApplicationClass
    }
}