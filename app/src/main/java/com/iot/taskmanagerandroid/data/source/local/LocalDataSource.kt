package com.iot.taskmanagerandroid.data.source.local

import com.iot.taskmanagerandroid.data.model.NetworkLoginResponse

interface LocalDataSource {

    suspend fun saveAuth(response: NetworkLoginResponse)
}