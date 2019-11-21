package com.lakooz.lpctest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lakooz.lpctest.model.Pot
import com.lakooz.lpctest.repositories.PotRepository

class PotsViewModel : ViewModel() {

    private val repository = PotRepository.instance

    // Done : initialize
    private val _pots = MutableLiveData<List<Pot>>()
    val pots: LiveData<List<Pot>>
        get() = _pots

    fun getPots(category: Int) {
        Log.d("hereee","PotsViewModel getting category $category from local : "+repository.getPots(category).toString())
        _pots.postValue(repository.getPots(category))
    }



}