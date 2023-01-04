package com.example1.projectapp.Models

import androidx.room.Embedded
import androidx.room.Entity;
import androidx.room.Relation

data class UserWithMedicament(
    @Embedded val user: User,
    @Relation(
    parentColumn = "userId",
    entityColumn = "medicamentId"
    )
    val Medicamentslist: List<Medicament>
)

