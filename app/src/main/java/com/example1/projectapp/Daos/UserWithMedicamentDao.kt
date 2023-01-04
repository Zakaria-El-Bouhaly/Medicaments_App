package com.example1.projectapp.Daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example1.projectapp.Models.UserWithMedicament

@Dao
interface UserWithMedicamentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(vararg item: UserWithMedicament)

    @Query("SELECT * FROM User")
    fun getUserWithMedicaments(): List<UserWithMedicament>
}