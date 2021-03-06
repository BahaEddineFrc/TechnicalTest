package com.lakooz.lpctest.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lakooz.lpctest.model.Pot
import io.reactivex.Maybe


@Dao
abstract class PotDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun createOrUpdate(pot: Pot) : Long //use return var to test its success

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAllAndSynchronize(pots: List<Pot>) : List<Long>

    @Query("SELECT * FROM POT WHERE category=:category ORDER BY creationDate DESC")
    abstract fun getPots(category: Int) : List<Pot>

}