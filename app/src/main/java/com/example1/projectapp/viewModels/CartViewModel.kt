package com.example1.projectapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example1.projectapp.Db.CartRepository
import com.example1.projectapp.Db.MedicamentRepository
import com.example1.projectapp.Db.MedicamentsDB
import com.example1.projectapp.Models.Cart
import com.example1.projectapp.Models.Medicament
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

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