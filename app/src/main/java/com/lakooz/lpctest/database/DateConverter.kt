package com.lakooz.lpctest.database

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {

    @TypeConverter
    fun fromTimestamp(mills: Long?): Date? {
       // TODO
    }

    @TypeConverter
    fun fromDate(date: Date?)  {
        // TODO
    }
}