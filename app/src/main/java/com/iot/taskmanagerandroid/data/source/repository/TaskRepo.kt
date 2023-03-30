package com.iot.taskmanagerandroid.data.source.repository

import com.iot.taskmanagerandroid.data.model.NetworkLoginResponse
import com.iot.taskmanagerandroid.data.model.request_params.LoginParams
import com.iot.taskmanagerandroid.utils.MyResult

interface TaskRepo {

    suspend fun login(params: LoginParams): MyResult<NetworkLoginResponse?>
}