package com.lakooz.lpctest.database

import androidx.room.TypeConverter
import java.util.Date



class DateConverter {
    // Done
    @TypeConverter
    fun fromTimestamp(mills: Long?): Date? {
        return if (mills == null) null else Date(mills)
    }

    @TypeConverter
    fun fromDate(date: Date?) : Long?  {
        return date?.time
    }
}