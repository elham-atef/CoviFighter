package com.example.covifighter

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_notification_message.*


class NotificationMessage : AppCompatActivity() {
    lateinit var textView :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_message)
        textView = tv_message
        val bundle :Bundle? = intent.extras
        textView.setText(bundle!!.getString("message"))
    }
}