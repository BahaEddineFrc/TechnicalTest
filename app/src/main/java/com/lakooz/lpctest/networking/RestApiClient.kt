package com.lakooz.lpctest.networking

import com.lakooz.lpctest.model.Pot
import io.reactivex.Single

object RestApiClient {

    private const val BASE_URL = "https://recrutement.lepotcommuntest.fr/2019/recruiting/"

    fun getPots(): Single<List<Pot>> {
        // TODO
    }

    fun createPot(category: Int): Single<Pot> {
        // TODO
    }
}