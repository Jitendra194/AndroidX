package com.pills.mydemoapplication.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import com.pills.mydemoapplication.repository.network.services.TokenService
import com.pills.mydemoapplication.utils.extention_utils.debug

class SessionManager(
    private val sharedPreferences: SharedPreferences,
    private val tokenService: TokenService
) {

    companion object {
        const val IS_USER_LOGGED_IN = "IS_USER_LOGGED_IN"
        const val AUTH_TOKEN = "AUTH_TOKEN"
        private const val GRANT_TYPE = "password"
        private const val CLIENT_ID = "3MVG96hCAx1bhPahgH3cGLf4BfzkC1XPQuytKXoecF01Zj9NwdG77ukpFp4YRgX.83QN6Wf8I2Pch5qzxgIGe"
        private const val CLIENT_SECRET = "000B8B2E721074BF9FE6AE128E2BEC5163448CB174C5F3A530B017E5EAD1A8A2"
        private const val USERNAME = "rohittatineni@popill.com"
        private const val PASSWORD = "Popill2020EuzPuJavTggCk3Oj6khC2SotM"
    }

    suspend fun getAccessToken(): String = tokenService.fetchAuthToken(GRANT_TYPE, CLIENT_ID, CLIENT_SECRET, USERNAME, PASSWORD).run {
        setAuthToken(this.access_token)
        this.access_token
    }

    private fun setAuthToken(token: String?) = sharedPreferences.edit { putString(AUTH_TOKEN, token) }
}