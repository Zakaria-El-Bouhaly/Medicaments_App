package com.example1.projectapp.Daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example1.projectapp.Models.Medicament

@Dao
interface MedicamentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMedicament(vararg medicament: Medicament)

    @Query("SELECT * FROM Medicament")
    fun getAll(): List<Medicament>
}