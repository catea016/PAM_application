package com.example.pam_app.cosmetics

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("/api/v1/products.json?product_category=powder&product_type=blush")
    fun getBlush(): Call<List<Cosmetics>>
/*    fun getBlush(@Query("image_link") image: String,
                 @Query("name") name: String,
                 @Query("price") price: Float): Call<List<Cosmetics>>*/

    companion object {

        var BASE_URL = "https://makeup-api.herokuapp.com"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}