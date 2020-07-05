package com.pills.login_module.repository

import com.pills.login_module.repository.models.User
import com.pills.login_module.repository.models.UserDataRequest
import com.pills.login_module.repository.services.LoginService
import com.pills.mydemoapplication.repository.local.database.AppDatabase

class LoginRepository(private val loginService: LoginService, private val roomDatabase: AppDatabase) {

    suspend fun fetchUserData(username: String): User {
        val response = loginService.getUserData(username)
        roomDatabase.userDao().insert(com.pills.mydemoapplication.repository.local.entities.User(response.Mobile_Number__c, response.First_Name__c, response.Last_Name__c))
        return response
    }

    suspend fun sendUserData(userDataRequest: UserDataRequest) {
        loginService.setUserData(userDataRequest)
    }
}