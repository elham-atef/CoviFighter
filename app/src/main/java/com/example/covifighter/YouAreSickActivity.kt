package com.example.covifighter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.you_are_sick.*

class YouAreSickActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.you_are_sick)

        // if Ok Button is clicked, move to Home Activity
        ok_sick_button.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
            System.exit(0)
        }
    }
    // if Back Button is pressed, return to CheckYourselfActivity
    override fun onBackPressed(){
        val intent = Intent(this, CheckYourselfActivity::class.java)
        startActivity(intent)
        finish()
        System.exit(0)
    }
}