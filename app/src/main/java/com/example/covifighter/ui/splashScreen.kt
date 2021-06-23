package com.example.covifighter.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.covifighter.R

class splashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //go from splash activity to another activity(home activity)
        val handler=Handler().postDelayed(Runnable {
            val intent=Intent(this, Home::class.java)
            startActivity(intent)
            finish()
        }
            ,2000)
    }
}