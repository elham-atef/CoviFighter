package com.example.covifighter.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.covifighter.DataBase.Alarm
import com.example.covifighter.DataBase.AlarmDataBase
import com.example.covifighter.R
import kotlinx.android.synthetic.main.create_event.*
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

                // setAlarm(value, date, time)

                val dialog = AlertDialog.Builder(this)
                    .setTitle("")
                    .setMessage("Your Alarm added successfully")
                    .setPositiveButton("ok", DialogInterface.OnClickListener { dialog, which ->
                        dialog.dismiss()
                        finish()
                    })
                    .setCancelable(false)
                    .show()

            }
    }

    fun selectTime(view: View) {

        val calender = Calendar.getInstance()
        val hour = calender.get(Calendar.HOUR)
        val minute = calender.get(Calendar.MINUTE)

        val tpd = TimePickerDialog(this,
            TimePickerDialog.OnTimeSetListener(function = { view, hour, minute ->

                Toast.makeText(this, hour.toString() + " : " + minute + " : ", Toast.LENGTH_LONG)
                    .show()
                btn_time.setText(FormatTime(hour,minute))

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
            }), year, month, day)
                    dpd.show()
    }
}




    fun FormatTime(hour: Int, minute: Int): String? {
        var time: String
        time = ""
        val formattedMinute: String
        formattedMinute = if (minute / 10 == 0) {
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
