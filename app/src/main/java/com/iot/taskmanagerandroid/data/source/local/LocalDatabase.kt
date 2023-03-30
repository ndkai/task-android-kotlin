package com.iot.taskmanagerandroid.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.iot.taskmanagerandroid.data.source.local.dao.LocalDao
import com.iot.taskmanagerandroid.data.source.local.entity.DBAuth

@Database(entities = [DBAuth::class], version = 1, exportSchema = true)
//@TypeConverters(
//    ListNetworkWeatherDescriptionConverter::class
//)
abstract class LocalDatabase : RoomDatabase() {

    abstract val localDao: LocalDao
}