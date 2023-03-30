package com.iot.taskmanagerandroid.ui.auth

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iot.taskmanagerandroid.data.model.NetworkLoginResponse
import com.iot.taskmanagerandroid.data.model.request_params.LoginParams
import com.iot.taskmanagerandroid.data.source.repository.TaskRepo
import com.iot.taskmanagerandroid.utils.MyResult
import com.iot.taskmanagerandroid.utils.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: TaskRepo,
) :
    ViewModel() {
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading.asLiveData()

    private val _loginResponse = MutableLiveData<NetworkLoginResponse?>()
    val loginResponse = _loginResponse.asLiveData()

    fun login() {
        _isLoading.postValue(true)
        Log.d("duy", "asdasdsd")
        viewModelScope.launch {
            when (val result = repository.login(LoginParams(email.value!!, password.value!!))) {
                is MyResult.Success -> {
                    _isLoading.value = false
                    if (result.data != null) {
                        val lg = result.data
                        _loginResponse.value = lg
                    }
                }
                is MyResult.Error -> {
                    _isLoading.value = false
                }

                is MyResult.Loading -> _isLoading.postValue(true)

            }
        }
    }

}