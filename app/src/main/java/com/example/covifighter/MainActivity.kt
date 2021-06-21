package com.example.covifighter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

        override fun onBackPressed() {
            val fragment =
                this.supportFragmentManager.findFragmentById(R.id.fragment_container)
            (fragment as? IOnBackPressed)?.onBackPressed()
            run {
                super.onBackPressed()

            }
        }
    }
