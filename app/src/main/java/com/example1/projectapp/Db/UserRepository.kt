package com.example1.projectapp.Db

import androidx.lifecycle.LiveData
import com.example1.projectapp.Daos.UserDao
import com.example1.projectapp.Models.User

class UserRepositoryDb(private  val userDao: UserDao) {
    fun insert(user: User) {
        Thread {
            userDao.insertUser(user)
        }.start()
    }
    fun findByEmail(email: String) : LiveData<User> {
        return userDao.findByEmail(email)
    }
}