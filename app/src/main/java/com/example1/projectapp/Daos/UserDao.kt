package com.example1.projectapp.Daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example1.projectapp.Models.Medicament
import com.example1.projectapp.Models.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(vararg user: User)

    @Query("SELECT * FROM user WHERE email like  :email")
    fun findByEmail(email: String): Array<User>

}