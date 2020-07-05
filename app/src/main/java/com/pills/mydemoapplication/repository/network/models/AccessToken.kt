package com.pills.mydemoapplication.repository.network.models

import com.google.gson.annotations.SerializedName


data class AccessToken(@SerializedName("access_token") val access_token: String)