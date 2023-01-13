package com.example1.projectapp.db

import com.example1.projectapp.daos.UserDao
import com.example1.projectapp.models.User

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