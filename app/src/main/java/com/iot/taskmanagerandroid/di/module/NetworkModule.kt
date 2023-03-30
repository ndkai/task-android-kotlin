package com.iot.taskmanagerandroid.di.module

import com.iot.taskmanagerandroid.data.source.remote.retrofit.AuthApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideInstantAuthApiService(retrofit: Retrofit): AuthApiService{
        return retrofit.create(AuthApiService::class.java)
    }
}