package com.example.covifighter

import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Context.ALARM_SERVICE
import android.content.DialogInterface
import android.content.Intent
import android.net.ParseException
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import com.example.covifighter.DataBase.Alarm
import com.example.covifighter.DataBase.AlarmDataBase
import kotlinx.android.synthetic.main.create_event.*
import kotlinx.android.synthetic.main.notification_layout.*
import kotlinx.android.synthetic.main.your_alarms_shape.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class CreateEvent : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_event)

        //نحط فيها حجات التاريخ والوقت وهكذا


        alarm_name.setOnClickListener(this)
        btn_time.setOnClickListener(this)
        btn_date.setOnClickListener(this)
        btn_ok.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        if (view == alarm_name) {
            val alarmName = alarm_name.text.toString()
        } else if (view == btn_time) {
            selectTime(view)
        } else if (view == btn_date) {
            selectDate(view)
        } else if (view == btn_ok) {
            submit()
        }
    }

    private fun submit() {
        val text: String = alarm_name.getText().toString().trim()
        if (text.isEmpty()) {
            Toast.makeText(this, "Please Enter the text", Toast.LENGTH_SHORT).show()
        } else
            if (btn_time.text.toString().equals("Put Your Time") || btn_date.text.toString()
                    .equals("Put Your Date")
            ) {
                Toast.makeText(this, "Please select date and time", Toast.LENGTH_SHORT).show()
            } else {

                val titleString = alarm_name.text.toString().trim()
                val yourTime = btn_time.text.toString().trim()
                val yourDate = btn_date.text.toString().trim()

                AlarmDataBase.getInstance(applicationContext).alarmDao()
                    .insert(Alarm(time = yourTime, date = yourDate, description = titleString))


                val dialog = AlertDialog.Builder(this)
                    .setTitle("")
                    .setMessage("Your Alarm added successfully")
                    .setPositiveButton("ok", DialogInterface.OnClickListener { dialog, which ->
                        dialog.dismiss()
                        finish()
                    })
                    .setCancelable(false)
                    .show()

                setAlarm(titleString, yourDate, yourTime)

            }
    }

    fun selectTime(view: View) {

        val calender = Calendar.getInstance()
        val hour = calender.get(Calendar.HOUR)
        val minute = calender.get(Calendar.MINUTE)

        val tpd = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener(function = { view, hour, minute ->

                Toast.makeText(this, hour.toString() + " : " + minute + "  ", Toast.LENGTH_LONG)
                    .show()
                btn_time.setText(FormatTime(hour, minute))

            }), hour, minute, false
        )

        tpd.show()
    }

    fun selectDate(view: View) {

        val calendar = Calendar.getInstance()
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DAY_OF_MONTH]
        val dpd=DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener(function = { view, year, month, day ->
                btn_date.setText("" + day + " " + month + ", " + year)
            }), year, month, day
        )
                    dpd.show()
    }
}


    fun FormatTime(hour: Int, minute: Int): String {
        var time: String
        time = ""
        var formattedMinute: String = if (minute / 10 == 0) {
            "0$minute"
        } else {
            "" + minute
        }
        time = if (hour == 0) {
            "12:$formattedMinute AM"
        } else if (hour < 12) {
            "$hour:$formattedMinute AM"
        } else if (hour == 12) {
            "12:$formattedMinute PM"
        } else {
            val temp = hour - 12
            "$temp:$formattedMinute PM"
        }
        return time
    }

private fun setAlarm(text: String, date: String, time: String) {
    val context1: Context? = CreateEvent()

    val am = context1?.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    val context: Context? = CreateEvent()
    val intent = Intent(context , AlarmBrodcast::class.java)

    intent.putExtra("event", text)
    intent.putExtra("date", date)
    intent.putExtra("time", time)
    val pendingIntent =
        PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_ONE_SHOT)
    val dateandtime = "$date $time"
    val formatter: DateFormat = SimpleDateFormat("d-M-yyyy hh:mm")
    try {
        val date1 = formatter.parse(dateandtime)
        am[AlarmManager.RTC_WAKEUP, date1.time] = pendingIntent
    } catch (e: ParseException) {
        e.printStackTrace()
    }
}

