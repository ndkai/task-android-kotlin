package com.iot.taskmanagerandroid.data.source.remote

import com.iot.taskmanagerandroid.data.model.NetworkLoginResponse
import com.iot.taskmanagerandroid.data.model.request_params.LoginParams
import com.iot.taskmanagerandroid.utils.MyResult

interface TMRemoteDataSource {

    suspend fun login(params: LoginParams): MyResult<NetworkLoginResponse>
}