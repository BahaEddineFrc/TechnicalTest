package com.lakooz.lpctest.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Pot(
    @PrimaryKey
    @SerializedName("id")
    val identifier: String,
    val name: String,
    val creationDate: String,
    val category: Int,
    val contributorsCount: Int,
    val amount: Double,
    val imageUrl: String?
) {

    companion object {
        const val CATEGORY_BIRTHDAY = 0
        const val CATEGORY_FAREWELL = 1
        const val CATEGORY_SOLIDARITY = 2
    }

    override fun toString(): String {
        return "Pot(id='$identifier', name='$name', creationDate='$creationDate', category=$category, contributersCount=$contributorsCount, amount=$amount, imageUrl=$imageUrl)"
    }


}