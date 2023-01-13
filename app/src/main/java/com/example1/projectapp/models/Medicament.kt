package com.example1.projectapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity
//    (
//    foreignKeys = [ForeignKey(
//        entity = User::class,
//        parentColumns = arrayOf("userId"),
//        childColumns = arrayOf("user"),
//        onDelete = ForeignKey.CASCADE
//    )]
//)
data class Medicament(
    @PrimaryKey val medicamentId: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "isVitamin") val isVitamin: Boolean?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "price") val price: Double?,
    @ColumnInfo(name = "substance") val substance: String?,
    @ColumnInfo(name = "dosageForm") val dosageForm: String?,
    @ColumnInfo(name = "dosage") val dosage: String?,
    @ColumnInfo(name = "manufacturer") val manufacturer: String?,
    @ColumnInfo(name = "image") val image: String?,


):Serializable