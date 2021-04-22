package com.example.pam_app.cosmetics.view

import com.example.pam_app.cosmetics.api.Cosmetics
import retrofit2.Response

interface View {
    fun init()
    fun showPostResponse(response: Response<Cosmetics>)
    fun showGetResponse(response: Response<List<Cosmetics>>)
}
