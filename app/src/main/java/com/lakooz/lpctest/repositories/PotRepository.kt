package com.lakooz.lpctest.repositories

import com.lakooz.lpctest.MyApplication
import com.lakooz.lpctest.database.PotDao
import com.lakooz.lpctest.model.Pot

class PotRepository(private val potDao: PotDao) {

    fun createOrUpdate(pot: Pot) : Long{
        return potDao.createOrUpdate(pot)
    }

    fun insertAllAndSynchronize(pots: List<Pot>) : List<Long> {
       return potDao.insertAllAndSynchronize(pots)
    }

    fun getPots(category: Int) = potDao.getPots(category)

    companion object {
        val instance : PotRepository= PotRepository(MyApplication.database.potDao())
    }

}