package com.example1.projectapp.Models

import androidx.room.Entity;

@Entity(primaryKeys = ["userId", "medId"])
data class UserMedicament(
    val userId: Int,
    val medId: Int
)

