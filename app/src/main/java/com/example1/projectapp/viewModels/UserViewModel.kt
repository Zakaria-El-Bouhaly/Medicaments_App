package com.example1.projectapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example1.projectapp.Db.MedicamentsDB
import com.example1.projectapp.Db.UserRepository
import com.example1.projectapp.Models.User

class UserViewModel (application: Application) : AndroidViewModel(application){
    private val repository: UserRepository

    init {
        val dao = MedicamentsDB.getDatabase(application).userDao()
        repository = UserRepository(dao)
    }
    fun insert(item: User) {
        repository.insert(item)
    }

//    fun delete(item: User) {
//        repository.delete(item)
//    }

    fun findByEmail(email:String) : User {
        return repository.findByEmail(email)
    }
}