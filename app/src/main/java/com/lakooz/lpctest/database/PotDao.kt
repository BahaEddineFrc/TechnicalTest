package com.lakooz.lpctest.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lakooz.lpctest.model.Pot


@Dao
abstract class PotDao {

    //Done
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun createOrUpdate(pot: Pot)

    @Insert
    abstract fun insertAllAndSynchronize(pots: List<Pot>)

    @Query("SELECT * FROM pot ORDER BY creationDate ASC")
    abstract fun getPots(category: Int) : List<Pot>

}