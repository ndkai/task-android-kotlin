package com.iot.taskmanagerandroid.di.module

import com.iot.taskmanagerandroid.data.source.local.LocalDataSource
import com.iot.taskmanagerandroid.data.source.local.LocalDataSourceImpl
import com.iot.taskmanagerandroid.data.source.remote.TMRemoteDataSource
import com.iot.taskmanagerandroid.data.source.remote.TMRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DatasourceModule {
    
    @Binds
    abstract fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: TMRemoteDataSourceImpl): TMRemoteDataSource
}