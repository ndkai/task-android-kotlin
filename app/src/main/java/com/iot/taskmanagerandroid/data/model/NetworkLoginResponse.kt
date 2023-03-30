package com.iot.taskmanagerandroid.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.time.LocalDateTime
import java.util.*

@Parcelize
data class NetworkLoginResponse (
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("token_type")
    val tokenType: String,

    val userID: String,

    val username: String,
    @SerializedName("expires_in")
    val expiresIn: Long,

    var dateExpired: LocalDateTime,

    ) : Parcelable