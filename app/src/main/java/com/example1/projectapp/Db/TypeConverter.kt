package com.example1.projectapp.Db

import androidx.room.ProvidedTypeConverter
import com.example1.projectapp.Models.Medicament
import com.google.gson.Gson
import androidx.room.TypeConverter

//@ProvidedTypeConverter
class TypeConverter {
    @TypeConverter
    fun toMedicament(value: String): Medicament {
        return Gson().fromJson(value,Medicament::class.java)
    }
    @TypeConverter
    fun fromMedicament(value: Medicament): String {
        return  Gson().toJson(value).toString()
    }
}