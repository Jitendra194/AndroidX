package com.pills.mydemoapplication.views.splash

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pills.mydemoapplication.R
import com.pills.mydemoapplication.repository.SessionManager.Companion.IS_USER_LOGGED_IN
import com.pills.mydemoapplication.views.hq.HQActivity
import com.pills.mydemoapplication.views.launch.LaunchActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPreferences: SharedPreferences = application.getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
        if (sharedPreferences.getBoolean(IS_USER_LOGGED_IN, false)) {
            startActivity(Intent(this, HQActivity::class.java))
        } else {
            startActivity(Intent(this, LaunchActivity::class.java))
        }
        finish()
    }
}
