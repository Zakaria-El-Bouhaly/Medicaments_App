package com.example1.projectapp.Daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example1.projectapp.Models.User
import com.example1.projectapp.Models.UserMedicament

@Dao
interface UserMedicamentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(vararg item: UserMedicament)
}