package com.iot.taskmanagerandroid.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "auth_table")
data class DBAuth (
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var uId: Int = 0,

    @ColumnInfo(name = "token")
    var token: String,

    @ColumnInfo(name = "name")
    var name: String
)