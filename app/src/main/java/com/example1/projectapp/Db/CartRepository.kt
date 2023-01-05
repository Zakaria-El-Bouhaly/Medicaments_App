package com.example1.projectapp.Db

import androidx.lifecycle.LiveData
import com.example1.projectapp.Daos.CartUserDao
import com.example1.projectapp.Daos.MedicamentDao
import com.example1.projectapp.Models.Cart
import com.example1.projectapp.Models.Medicament
import com.example1.projectapp.Models.User

class CartRepository(private val cartDao: CartUserDao) {
    fun insert(cart: Cart) {
        Thread {
            cartDao.insertItem(cart)
        }.start()
    }
    fun getAllCartByUserId(id: Int): LiveData<List<Medicament>> {
        return cartDao.getAllCart(id)
    }
}