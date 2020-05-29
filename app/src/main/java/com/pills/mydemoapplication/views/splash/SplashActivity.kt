package com.pills.mydemoapplication.views.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pills.mydemoapplication.views.launch.LaunchActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, LaunchActivity::class.java)
        startActivity(intent)
        finish()
    }
}
