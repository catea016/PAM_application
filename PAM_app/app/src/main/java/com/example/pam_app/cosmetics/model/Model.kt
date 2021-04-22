package com.example.pam_app.cosmetics.model

import com.example.pam_app.cosmetics.api.Cosmetics
import com.example.pam_app.cosmetics.api.Repository
import retrofit2.Response

class Model(private val repository: Repository) {

    suspend fun putItem(cosmetics: Cosmetics): Response<Cosmetics> {
        return repository.putItem(cosmetics)
    }

    suspend fun postSmth(cosmetics: Cosmetics): Response<Cosmetics> {
        return repository.postSmth(cosmetics)
    }

    suspend fun getBlush(): Response<List<Cosmetics>> {
        return repository.getBlush()
    }

    suspend fun getLipstick(): Response<List<Cosmetics>> {
        return repository.getLipstick()
    }
}