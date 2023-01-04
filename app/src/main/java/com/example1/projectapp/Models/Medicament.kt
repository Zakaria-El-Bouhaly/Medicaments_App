package com.example1.projectapp.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Medicament(
    @PrimaryKey val medicamentId: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "isVitamin") val isVitamin: Boolean?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "price") val price: Double?,
    @ColumnInfo(name = "substance") val substance: String?,
    @ColumnInfo(name = "dosageForm") val dosageForm: String?,
    @ColumnInfo(name = "dosage") val dose: String?,
    @ColumnInfo(name = "manufacturer") val manufacturer: String?,
    @ColumnInfo(name = "image") val image: String?

):Serializable