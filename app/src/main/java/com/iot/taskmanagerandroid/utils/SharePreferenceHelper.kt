package com.iot.taskmanagerandroid.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.google.gson.Gson
import com.iot.taskmanagerandroid.data.model.NetworkLoginResponse
import java.time.LocalDate
import java.time.LocalDateTime
import javax.inject.Inject

class SharePreferenceHelper @Inject constructor() {
    companion object{
            private const val LOGIN = "LOGIN"
        private var pref: SharedPreferences? = null

        @Volatile
        private var instance: SharePreferenceHelper? = null

        fun getInstance(context: Context): SharePreferenceHelper {
            synchronized(this){
                val _instance = instance
                if(_instance == null){
                    pref = PreferenceManager.getDefaultSharedPreferences(context)
                    instance = _instance
                }
                return SharePreferenceHelper()
            }
        }
    }

    fun saveLoginResponse(loginModel: NetworkLoginResponse){
      pref?.edit(commit = true){
          val gson = Gson()
          var date = LocalDateTime.now().plusSeconds(loginModel.expiresIn)
          loginModel.dateExpired = date
          val json = gson.toJson(loginModel)
          putString(LOGIN, json)
      }
    }

    fun getLoginResponse(): NetworkLoginResponse{
        val gson = Gson()
        val json = pref?.getString(LOGIN, null)
        return gson.fromJson(json, NetworkLoginResponse::class.java)
    }
}