package com.example.covifighter

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.covifighter.ui.AlarmFragment


class BootUpReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val intent1 = Intent(context, CreateEvent::class.java)
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent1)
    }
}