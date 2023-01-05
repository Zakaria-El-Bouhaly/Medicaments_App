package com.example1.projectapp.Models

import androidx.room.*
@Entity
data class Cart(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "user_id") val user_id:Int,
    @ColumnInfo(name = "medicament") val medicament: Medicament
)

