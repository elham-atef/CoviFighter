
package com.example.covifighter.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Alarm::class),version = 1,exportSchema = false)
abstract class AlarmDataBase :RoomDatabase() {


    abstract fun alarmDao():AlarmDao

    companion object {   //to set fun public and static

        private val DATABASE_NAME = "alarm-database"
        fun getInstance(context: Context): AlarmDataBase {
            val alarmDataBase = Room.databaseBuilder(
                context, AlarmDataBase::class.java, DATABASE_NAME
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
            return alarmDataBase
        }
    }

}
