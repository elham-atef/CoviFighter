
package com.example.covifighter.DataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "alarm")
data class Alarm (     //data class of database

   @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
   @ColumnInfo
    val time:String?=null,
   @ColumnInfo
    val date:String?=null,
   @ColumnInfo
    val description:String?=null
)

