package com.lakooz.lpctest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreatePotViewModel : ViewModel() {

    private val _pot = MutableLiveData<Boolean>()
    val pot: LiveData<Boolean>
        get() = _pot

    //todo : create pot with opened category

}