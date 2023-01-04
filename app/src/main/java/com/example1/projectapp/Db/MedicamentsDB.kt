package com.example1.projectapp.Db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example1.projectapp.Daos.MedicamentDao
import com.example1.projectapp.Daos.UserDao
import com.example1.projectapp.Models.Medicament
import com.example1.projectapp.Models.User

@Database(entities = [User::class,Medicament::class], version = 1, exportSchema = false)

abstract  class MedicamentsDB : RoomDatabase(){
    abstract fun userDao() : UserDao
    abstract fun medicamentDao() : MedicamentDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDatabase? = null

        fun getDatabase(context: Context): MedicamentsDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance as MedicamentsDB
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,MedicamentsDB::class.java,
                    "MedicamentsDB").fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}