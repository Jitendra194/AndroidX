package com.example.lab_hub.di.components

import com.example.lab_hub.di.modules.ViewModelProviderModule
import com.example.lab_hub.views.LabReportsFragment
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Subcomponent(
    modules = [AndroidInjectionModule::class,
        ViewModelProviderModule::class]
)
interface LabReportsFeatureComponent : AndroidInjector<LabReportsFragment> {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance labReportsFragment: LabReportsFragment): LabReportsFeatureComponent
    }
}