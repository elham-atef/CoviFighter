package com.example.covifighter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.you_are_fine.*

class YouAreFineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.you_are_fine)
        // if Ok Button is clicked, move to Home Activity
        ok_fine_button.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
    // if Back Button is pressed, return to CheckYourselfActivity
    override fun onBackPressed(){
        val intent = Intent(this, CheckYourselfActivity::class.java)
        startActivity(intent)
        finish()
    }
}