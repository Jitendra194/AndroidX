package com.pills.login_module.repository

import com.pills.login_module.repository.models.User
import com.pills.login_module.repository.services.LoginService

class LoginRepository(private val loginService: LoginService) {

    suspend fun fetchUserData(username: String): User = loginService.getUserData(username)
}