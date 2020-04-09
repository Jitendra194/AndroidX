package com.example.prescriptions_hub.di.components

import com.example.prescriptions_hub.views.PrescriptionsFragment
import com.example.prescriptions_hub.di.modules.ViewModelProviderModule
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Subcomponent(
    modules = [AndroidInjectionModule::class,
        ViewModelProviderModule::class]
)
interface PrescriptionsFeatureComponent : AndroidInjector<PrescriptionsFragment> {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance prescriptionsFragment: PrescriptionsFragment): PrescriptionsFeatureComponent
    }
}