package com.example1.projectapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example1.projectapp.db.CartRepository
import com.example1.projectapp.db.MedicamentsDB
import com.example1.projectapp.models.Cart

public  class CartViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: CartRepository

    init {
        val dao = MedicamentsDB.getDatabase(application).cartUserDao()
        repository = CartRepository(dao)
    }

    fun insert(cart: Cart) {
        repository.insert(cart)
    }
    fun delete(cart: Cart) {
        repository.delete(cart)
    }
    fun getAllCartByUser(id: Int): LiveData<List<Cart>> {
        return repository.getAllCartByUser(id)
    }
}