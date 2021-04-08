package com.example.pam_app.cosmetics

import retrofit2.Response

class Repository() {

    suspend fun getBlush(): Response<List<Cosmetics>> {
        return RetrofitBuilder.api.getBlush()
    }

    suspend fun getLipstick(): Response<List<Cosmetics>> {
        return RetrofitBuilder.api.getLipstick()
    }

    suspend fun putItem(cosmetics: Cosmetics): Response<Cosmetics> {
        return RetrofitBuilder.api.putItem(cosmetics)
    }

    suspend fun postSmth(cosmetics: Cosmetics): Response<Cosmetics> {
        return RetrofitBuilder.api.putItem(cosmetics)
    }
}