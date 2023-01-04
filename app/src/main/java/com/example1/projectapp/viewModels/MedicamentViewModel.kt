package com.example1.projectapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example1.projectapp.Db.MedicamentRepository
import com.example1.projectapp.Db.MedicamentsDB
import com.example1.projectapp.Models.Medicament
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

class MedicamentViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: MedicamentRepository
    val allMedicaments: LiveData<List<Medicament>>

    init {
        val dao = MedicamentsDB.getDatabase(application).medicamentDao()
        repository = MedicamentRepository(dao)
        allMedicaments = repository.allMedicaments
    }

    fun insert(item: Medicament) {
        repository.insert(item)
    }

    fun getMedicamentById(id: Int): Medicament {
        return repository.getMedicamentById(id)
    }

    fun getMedicamentByName(name: String): LiveData<List<Medicament>> {
        return repository.getMedicamentByName(name)
    }
}