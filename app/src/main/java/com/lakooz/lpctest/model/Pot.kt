package com.lakooz.lpctest.model

import androidx.room.Entity

@Entity
data class Pot(
    val identifier: String,
    val name: String
    // TODO : add missing fields
) {


    companion object {
        const val CATEGORY_BIRTHDAY = 0
        const val CATEGORY_FAREWELL = 1
        const val CATEGORY_SOLIDARITY = 2
    }
}