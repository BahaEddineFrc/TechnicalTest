package com.lakooz.lpctest

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
        _pots.value = repository.getPots(category)
    }



}