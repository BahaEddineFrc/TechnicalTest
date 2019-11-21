package com.lakooz.lpctest.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import com.lakooz.lpctest.MyApplication
import com.lakooz.lpctest.database.PotDao
import com.lakooz.lpctest.model.Pot
import io.reactivex.Maybe
import io.reactivex.Single

class PotRepository(private val potDao: PotDao) {

    fun createOrUpdate(pot: Pot) : Long{
        return potDao.createOrUpdate(pot)
    }

    fun insertAllAndSynchronize(pots: List<Pot>) : List<Long> {
       return potDao.insertAllAndSynchronize(pots)
        //Log.d("hereee","PotRepository getting instance : "+instance)
    }

    fun getPots(category: Int) = potDao.getPots() //category

    companion object {
        // TODO : toTest
        val instance : PotRepository= PotRepository(MyApplication.database.potDao())
    }

}