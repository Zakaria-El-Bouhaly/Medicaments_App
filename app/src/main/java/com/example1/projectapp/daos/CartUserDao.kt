package com.example1.projectapp.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example1.projectapp.Models.Cart

@Dao
interface CartUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(vararg item: Cart)
    @Delete
    fun deleteItem(vararg item: Cart)

    @Query("SELECT * FROM cart where user_id==:id")
    fun getAllCartByUser(id: Int): LiveData<List<Cart>>

}