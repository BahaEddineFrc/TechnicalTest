package com.lakooz.lpctest.repositories

import androidx.lifecycle.LiveData
import com.lakooz.lpctest.database.PotDao
import com.lakooz.lpctest.model.Pot
import io.reactivex.Single

class PotRepository(private val potDao: PotDao) {

    fun createOrUpdate(pot: Pot) {
        potDao.createOrUpdate(pot)
    }

    fun insertAllAndSynchronize(pots: List<Pot>) {
        potDao.insertAllAndSynchronize(pots)
    }

    fun getPots(category: Int) = potDao.getPots(category)

    companion object {
        // TODO : initialize
        val instance : PotRepository
    }

}