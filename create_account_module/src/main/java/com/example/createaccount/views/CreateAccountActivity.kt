package com.example.createaccount.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.createaccount.R
import com.example.createaccount.createAccountMainComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class CreateAccountActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        createAccountMainComponent.createAccountComponentFactory
            .create(this)
            .inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}