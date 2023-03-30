package com.iot.taskmanagerandroid.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iot.taskmanagerandroid.ViewModelFactory
import com.iot.taskmanagerandroid.di.key.ViewModelKey
import com.iot.taskmanagerandroid.ui.auth.LoginFragment
import com.iot.taskmanagerandroid.ui.auth.LoginViewModel
import com.iot.taskmanagerandroid.ui.home.HomeFragment
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@InstallIn(SingletonComponent::class)
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginFragmentViewModel(viewModel: LoginViewModel): ViewModel
    
}