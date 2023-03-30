package com.iot.taskmanagerandroid.data.source.remote.retrofit

import com.iot.taskmanagerandroid.data.model.NetworkLoginResponse
import com.iot.taskmanagerandroid.data.model.request_params.LoginParams
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApiService {

    @POST("http://202.78.227.81:30040/api/Users/Login")
    suspend fun login(
        @Body() params: LoginParams
    ): Response<NetworkLoginResponse>
}