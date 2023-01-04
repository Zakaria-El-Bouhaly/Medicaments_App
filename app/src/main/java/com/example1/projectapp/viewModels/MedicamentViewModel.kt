package com.example1.projectapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example1.projectapp.Db.MedicamentRepository
import com.example1.projectapp.Db.MedicamentsDB
import com.example1.projectapp.Models.Medicament

class MedicamentViewModel(application: Application,id:Int) : AndroidViewModel(application) {
    private val repository: MedicamentRepository
    val allMedicaments: LiveData<List<Medicament>>
    val MedicamentById: LiveData<Medicament>

    init {
        val dao = MedicamentsDB.getDatabase(application).medicamentDao()
        repository = MedicamentRepository(dao,id)
        allMedicaments = repository.allMedicaments
        MedicamentById = repository.MedicamentById
    }
    fun insert(item: Medicament) {
        repository.insert(item)
    }
}