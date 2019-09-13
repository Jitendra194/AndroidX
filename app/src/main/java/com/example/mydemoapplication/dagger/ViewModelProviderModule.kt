package com.example.mydemoapplication.dagger

import com.example.mydemoapplication.LoginViewModel
import dagger.Module
import dagger.Provides

@Module
abstract class ViewModelProviderModule  {
    @Provides
    fun providesLoginViewModel(): LoginViewModel {

        return LoginViewModel()
    }
}