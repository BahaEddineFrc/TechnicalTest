package com.lakooz.lpctest.networking

import com.lakooz.lpctest.model.Pot
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RestApiInterface {

    @GET("/get-pots")
    fun getPots(): Single<List<Pot>> //Single<Response<List<Pot>>>


    @FormUrlEncoded
    @POST("/create-pot")
    fun createPot( @Field("category") category: Int ) : Single<Pot>

}