package com.example1.projectapp.Daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example1.projectapp.Models.Cart
import com.example1.projectapp.Models.Medicament

@Dao
interface CartUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(vararg item: Cart)
    @Transaction
    @Query("SELECT medicament FROM cart where user_id==:id")
    fun getAllCart(id: Int): LiveData<List<Medicament>>
}