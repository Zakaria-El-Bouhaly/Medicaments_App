package com.example1.projectapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example1.projectapp.Db.MedicamentsDB
import com.example1.projectapp.Db.UserRepositoryDb
import com.example1.projectapp.Models.User

class UserViewModel (application: Application) : AndroidViewModel(application){
    private val repository: UserRepositoryDb

    init {
        val dao = MedicamentsDB.getDatabase(application).userDao()
        repository = UserRepositoryDb(dao)
    }
    fun insert(item: User) {
        repository.insert(item)
    }

//    fun delete(item: User) {
//        repository.delete(item)
//    }

    fun get(email:String) = repository.findByEmail(email)
}