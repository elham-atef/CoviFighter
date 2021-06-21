package com.example.covifighter

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_notification_message.*


class NotificationMessage : AppCompatActivity() {
    val textView :TextView = tv_message

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_message)

        val bundle = intent.extras
        textView.setText(bundle!!.getString("message"))
    }
}