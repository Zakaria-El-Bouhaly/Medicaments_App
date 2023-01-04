package com.example1.projectapp.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Medicament(
    @PrimaryKey val medicamentId: Int,
    @ColumnInfo(name = "name") val nom: String?,
    @ColumnInfo(name = "isVitamin") val isVitamin: Boolean?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "price") val prix: Double?,
    @ColumnInfo(name = "substance") val substance: String?,
    @ColumnInfo(name = "dosageForm") val dosageForm: String?,
    @ColumnInfo(name = "dosage") val dose: String?,
    @ColumnInfo(name = "manufacturer") val manufacturer: String?

)