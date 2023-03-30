package com.iot.taskmanagerandroid.di.module

import com.iot.taskmanagerandroid.data.source.repository.TaskRepo
import com.iot.taskmanagerandroid.data.source.repository.TaskRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepoModule {

    @Binds
    abstract fun bindRepo(taskRepoImpl: TaskRepoImpl): TaskRepo
}