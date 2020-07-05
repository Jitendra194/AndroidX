package com.pills.login_module.repository.services

import com.pills.login_module.repository.models.User
import com.pills.login_module.repository.models.UserDataRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LoginService {
    @GET("api/Entity/{username}")
    suspend fun getUserData(@Path("username") username: String): User

    @POST("api/Entity/")
    suspend fun setUserData(@Body userDataRequest: UserDataRequest): String
}