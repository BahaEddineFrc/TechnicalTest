package com.lakooz.lpctest.database

import android.content.Context
import androidx.room.RoomDatabase

// TODO
abstract class AppDatabase : RoomDatabase() {

    //TODO

    companion object {

        private const val DATABASE_NAME = "db_lpc_test"
        private var instance: AppDatabase? = null


        // TODO : implement
        fun buildDatabase(context: Context) : AppDatabase {

        }

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(AppDatabase::class.java) {
                    if (instance == null) {
                        instance =
                            buildDatabase(context.applicationContext)
                    }
                }
            }
            return instance!!
        }

    }
}