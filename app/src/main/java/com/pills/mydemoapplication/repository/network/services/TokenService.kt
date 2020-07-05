package com.pills.mydemoapplication.repository.network.services

import com.pills.mydemoapplication.repository.network.models.AccessToken
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TokenService {

    @POST("token")
    @FormUrlEncoded
    suspend fun fetchAuthToken(
        @Field("grant_type") grantType: String,
        @Field("client_id") consumerKey: String,
        @Field("client_secret") clientSecret: String,
        @Field("username") username: String,
        @Field("password") password: String
    ): AccessToken
}