package com.example.pam_app.cosmetics.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @GET("/api/v1/products.json?product_category=powder&product_type=blush")
    suspend fun getBlush(): Response<List<Cosmetics>>

    @GET("/api/v1/products.json?product_category=lipstick&product_type=lipstick")
    suspend fun getLipstick(): Response<List<Cosmetics>>

    @POST("/api/v1/products.json")
    suspend fun putItem(@Body cosmetics: Cosmetics): Response<Cosmetics>

    @POST("/api/v1/products.json?product_type=eyeshadow")
    suspend fun postSmth(@Body cosmetics: Cosmetics): Response<Cosmetics>
}