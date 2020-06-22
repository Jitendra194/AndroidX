package com.pills.login_module.repository.services

import com.pills.login_module.repository.models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface LoginService {
    @GET("api/Entity/{username}")
    suspend fun getUserData(@Path("username") username: String): User
}