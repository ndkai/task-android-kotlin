package com.iot.taskmanagerandroid.data.source.remote

import android.util.Log
import com.iot.taskmanagerandroid.data.model.NetworkLoginResponse
import com.iot.taskmanagerandroid.data.model.request_params.LoginParams
import com.iot.taskmanagerandroid.data.source.remote.retrofit.AuthApiService
import com.iot.taskmanagerandroid.utils.MyResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.math.log

class TMRemoteDataSourceImpl @Inject constructor(
    private val authService: AuthApiService
): TMRemoteDataSource{
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
    
    override suspend fun login(params: LoginParams): MyResult<NetworkLoginResponse> =
        withContext(ioDispatcher){
            return@withContext try{
                val result = authService.login(
                    params
                )
                Log.d("lololol", result.toString())
                if(result.isSuccessful){
                    val data = result.body()
                    MyResult.Success(data)
                } else {
                    MyResult.Success(null)
                }
            } catch (exception: Exception){
                Log.d("Exception", exception.toString())
                MyResult.Error(exception)
            }
    }
}