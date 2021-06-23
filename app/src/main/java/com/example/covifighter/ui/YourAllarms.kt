package com.example.covifighter.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.covifighter.DataBase.AlarmDataBase
import com.example.covifighter.R
import com.example.covifighter.adpter.YourAlarmsAdapter
import kotlinx.android.synthetic.main.your_allarms.*

class YourAllarms:AppCompatActivity() {
    val adapter=YourAlarmsAdapter(null)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.your_allarms)
        //نحط الريسايكلر فيو والداتا بيز

        AlarmDataBase.getInstance(getApplicationContext());


        recycleview.adapter=adapter
    }

    // to refresh any new alarm added put this list on fun on start
    override fun onStart() {
        super.onStart()
        val list = AlarmDataBase.getInstance(this).alarmDao()
            .getAllAlarms()
        adapter.changeData(list)
    }
}