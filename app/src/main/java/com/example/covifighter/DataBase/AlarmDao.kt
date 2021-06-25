
package com.example.covifighter.DataBase

import androidx.room.*

@Dao
interface AlarmDao {

    //contains all operations room needed

    @Insert
    fun insert(alarm: Alarm)

    @Delete
    fun delete(alarm: Alarm)

    @Update
    fun update(alarm: Alarm)

    @Query("select * from alarm")
    fun getAllAlarms():List<Alarm>
}
