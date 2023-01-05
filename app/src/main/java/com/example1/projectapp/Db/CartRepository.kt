package com.example1.projectapp.Db

import androidx.lifecycle.LiveData
import com.example1.projectapp.Daos.CartUserDao
import com.example1.projectapp.Models.Cart


class CartRepository(private val cartDao: CartUserDao) {
    fun insert(cart: Cart) {
        Thread {
            cartDao.insertItem(cart)
        }.start()
    }
    fun delete(cart: Cart) {
        Thread {
            cartDao.deleteItem(cart)
        }.start()
    }
    fun getAllCartByUser(id: Int): LiveData<List<Cart>> {
        return cartDao.getAllCartByUser(id)
    }
}