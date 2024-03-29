package com.example1.projectapp.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example1.projectapp.models.Medicament

@Dao
interface MedicamentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMedicament(vararg medicament: Medicament)

    @Query("SELECT * FROM Medicament")
    fun getAll(): LiveData<List<Medicament>>

    @Query("SELECT * FROM Medicament where medicamentId = :id")
    fun getMedicamentById(id: Int): Medicament

    @Query("SELECT * FROM Medicament where name Like :medicamentName")
    fun getMedicamentByName(medicamentName: String): LiveData<List<Medicament>>
}