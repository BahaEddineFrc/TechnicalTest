package com.lakooz.lpctest

import android.app.Application
import com.lakooz.lpctest.database.AppDatabase

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // TODO : toTest
        database = AppDatabase.getInstance(applicationContext)

    }

    companion object {

        lateinit var database: AppDatabase
        private set

    }
}