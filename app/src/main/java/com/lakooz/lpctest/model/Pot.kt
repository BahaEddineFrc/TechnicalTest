package com.lakooz.lpctest.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pot(
    @PrimaryKey
    val identifier: String,
    val name: String,
    val creationDate: String,
    val category: Int,
    val contributersCount: Int,
    val amount: Double,
    val imageUrl: String?
) {
    //todo

    companion object {
        const val CATEGORY_BIRTHDAY = 0
        const val CATEGORY_FAREWELL = 1
        const val CATEGORY_SOLIDARITY = 2
    }

    override fun toString(): String {
        return "Pot(id='$identifier', name='$name', creationDate='$creationDate', category=$category, contributersCount=$contributersCount, amount=$amount, imageUrl=$imageUrl)"
    }


}