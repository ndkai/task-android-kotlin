package com.iot.taskmanagerandroid.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iot.taskmanagerandroid.data.model.NetworkLoginResponse
import org.jetbrains.annotations.NotNull

@Dao
interface LocalDao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAuth(vararg response: NetworkLoginResponse)

//    @Query("SELECT * FROM auth_table ORDER BY id DESC LIMIT 1")
//    @NotNull
//    suspend fun getAuth(): NetworkLoginResponse
}                                               