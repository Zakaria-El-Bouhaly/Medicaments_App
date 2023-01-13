package com.example1.projectapp.Db

import androidx.lifecycle.LiveData
import com.example1.projectapp.daos.UserDao
import com.example1.projectapp.Models.User

class UserRepository(private  val userDao: UserDao) {
    fun insert(user: User) {
        Thread {
            userDao.insertUser(user)
        }.start()
    }
    fun findByEmail(email: String): User {
        return userDao.findByEmail(email)
    }
}