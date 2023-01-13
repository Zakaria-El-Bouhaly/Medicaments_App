package com.example1.projectapp.db

import androidx.lifecycle.LiveData
import com.example1.projectapp.daos.MedicamentDao
import com.example1.projectapp.models.Medicament

class MedicamentRepository(private val medicamentDao: MedicamentDao) {
    val allMedicaments: LiveData<List<Medicament>> = medicamentDao.getAll()
    fun insert(medicament: Medicament) {
        Thread {
            medicamentDao.insertMedicament(medicament)
        }.start()
    }

    fun getMedicamentById(id: Int): Medicament {
        return medicamentDao.getMedicamentById(id)
    }

    fun getMedicamentByName(medicamentName: String): LiveData<List<Medicament>> {
        return medicamentDao.getMedicamentByName(medicamentName)
    }
}