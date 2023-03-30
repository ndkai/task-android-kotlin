package com.iot.taskmanagerandroid.data.source.repository

import android.util.Log
import com.iot.taskmanagerandroid.data.model.NetworkLoginResponse
import com.iot.taskmanagerandroid.data.model.request_params.LoginParams
import com.iot.taskmanagerandroid.data.source.local.LocalDataSource
import com.iot.taskmanagerandroid.data.source.remote.TMRemoteDataSource
import com.iot.taskmanagerandroid.utils.MyResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TaskRepoImpl @Inject constructor(
    private val remoteDataSource: TMRemoteDataSource,
    private val localDataSource: LocalDataSource
): TaskRepo {
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun login(params: LoginParams): MyResult<NetworkLoginResponse?> =
        withContext(ioDispatcher) {
            when (val response = remoteDataSource.login(params)) {
                is MyResult.Success -> {
                    if (response.data != null) {
                        Log.d("TaskRepoImpl", response.data.toString())
                        MyResult.Success(response.data)
                    } else {
                        MyResult.Success(null)
                    }
                }

                is MyResult.Error -> {
                    Log.d("TaskRepoImpl", "zooo")
                    MyResult.Error(response.exception)
                }

                else -> MyResult.Loading
            }
        }

}