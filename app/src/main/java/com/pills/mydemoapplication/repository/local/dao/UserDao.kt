package com.pills.mydemoapplication.repository.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pills.mydemoapplication.repository.local.entities.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getUser(): LiveData<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("DELETE FROM User")
    suspend fun deleteAll()
}