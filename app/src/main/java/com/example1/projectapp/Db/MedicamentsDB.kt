package com.example1.projectapp.Db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example1.projectapp.Daos.MedicamentDao
import com.example1.projectapp.Daos.UserDao
import com.example1.projectapp.Models.Medicament
import com.example1.projectapp.Models.User
import com.example1.projectapp.utils.ioThread
import java.util.concurrent.Executors
import kotlin.math.roundToInt
import kotlin.random.Random

@Database(entities = [User::class, Medicament::class], version = 1, exportSchema = false)

abstract class MedicamentsDB : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun medicamentDao(): MedicamentDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDatabase? = null

        fun getDatabase(context: Context): MedicamentsDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance as MedicamentsDB
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, MedicamentsDB::class.java,
                    "MedicamentsDB"
                ).addCallback(seedDatabaseCallback(context.applicationContext))
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }

        fun seedDatabaseCallback(context: Context): Callback {
            return object : Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    ioThread {
                        var yourDao = getDatabase(context).medicamentDao()
                        for (i in 1 until 11) {
                            yourDao.insertMedicament(
                                Medicament(
                                    i,
                                    "Medicament$i",
                                    false,
                                    "Description1",
                                    (Random.nextDouble(1.0,100.0) * 100.0).roundToInt() / 100.0,
                                    "substance $i",
                                    "form$i",
                                    "${Random.nextInt(1,10)} mg",
                                    "USA",
                                    "medicament$i.jpg"
                                )
                            )
                        }
                    }
                }
            }

        }
    }
}