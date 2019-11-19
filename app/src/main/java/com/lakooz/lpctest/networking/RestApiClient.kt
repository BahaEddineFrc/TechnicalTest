package com.lakooz.lpctest.networking

import com.lakooz.lpctest.model.Pot
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RestApiClient {

    private const val BASE_URL = "https://recrutement.lepotcommuntest.fr/2019/recruiting/"


    private fun retrofit() : Retrofit =  Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        //.client(httpClient.build())
        .build()

    private val retrofit : RestApiInterface = retrofit().create(RestApiInterface::class.java)


    fun getPots(): Single<List<Pot>> {
       return retrofit.getPots()
    }

    fun createPot(category: Int): Single<Pot> {
        return retrofit.createPot(category)
    }
}