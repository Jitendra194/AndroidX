package com.pills.login_module.repository.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserDataRequest(
    @SerializedName("fName") var fName: String?,
    @SerializedName("lName") var lName: String?,
    @SerializedName("suppliedEmail") var suppliedEmail: String?,
    @SerializedName("suppliedMobile") var suppliedMobile: String?,
    @SerializedName("DOB") var DOB: String?,
    @SerializedName("gender") var gender: String?,
    @SerializedName("status") var status: String? = "Active"
): Parcelable