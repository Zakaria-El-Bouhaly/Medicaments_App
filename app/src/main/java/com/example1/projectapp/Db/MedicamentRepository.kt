package com.example1.projectapp.Db

import androidx.lifecycle.LiveData
import com.example1.projectapp.Daos.MedicamentDao
import com.example1.projectapp.Models.Medicament
import com.example1.projectapp.Models.User

class MedicamentRepository(private  val medicamentDao: MedicamentDao) {
    val allMedicaments: LiveData<List<Medicament>> = medicamentDao.getAll()
    fun insert(medicament: Medicament) {
        Thread {
            medicamentDao.insertMedicament(medicament)
        }.start()
    }
}