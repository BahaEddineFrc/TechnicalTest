package com.lakooz.lpctest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lakooz.lpctest.model.Pot


// 1.Database: Contains the database holder and serves as the main access point for the connection to data
// 2.Entity: Represents a table within the database
// 3.DAO: Contains the methods used for accessing the database

// Done entities
@Database(entities = [Pot::class], version = 1)
@TypeConverters(DateConverter::class)

abstract class AppDatabase : RoomDatabase() {

    //Done : potDao

    abstract fun potDao() : PotDao

    companion object {

        private const val DATABASE_NAME = "db_lpc_test"

        @Volatile
        private var instance: AppDatabase? = null


        // Done : implement
        private fun buildDatabase(context: Context) : AppDatabase {
            return Room.
                databaseBuilder( context, AppDatabase::class.java, DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
        }

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(AppDatabase::class.java) {
                    if (instance == null) {
                        instance = buildDatabase(context.applicationContext)
                    }
                }
            }
            return instance!!
        }

    }
}