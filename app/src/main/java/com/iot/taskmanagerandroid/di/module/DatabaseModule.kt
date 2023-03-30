package com.iot.taskmanagerandroid.di.module

import android.content.Context
import androidx.room.Room
import com.iot.taskmanagerandroid.data.source.local.LocalDatabase
import com.iot.taskmanagerandroid.data.source.local.dao.LocalDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): LocalDatabase {
        return Room.databaseBuilder(
            context,
            LocalDatabase::class.java, "tm.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideLocalDao(database: LocalDatabase): LocalDao{
        return database.localDao
    }


}