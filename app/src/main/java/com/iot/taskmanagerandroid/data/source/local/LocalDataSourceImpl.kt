package com.iot.taskmanagerandroid.data.source.local

import com.iot.taskmanagerandroid.data.model.NetworkLoginResponse
import com.iot.taskmanagerandroid.data.source.local.dao.LocalDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val localDao: LocalDao
): LocalDataSource{
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    
    override suspend fun saveAuth(response: NetworkLoginResponse) =
        withContext(ioDispatcher){
//            localDao
        }


}