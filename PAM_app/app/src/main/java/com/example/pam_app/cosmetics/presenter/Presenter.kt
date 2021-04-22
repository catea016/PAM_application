package com.example.pam_app.cosmetics.presenter

import com.example.pam_app.cosmetics.api.Cosmetics
import com.example.pam_app.cosmetics.model.Model
import com.example.pam_app.cosmetics.view.View
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Presenter(private val view: View, private val model: Model) {

    fun initView() {
        view.init()
    }

    fun putItem(cosmetics: Cosmetics) {
        GlobalScope.launch {
            val response = model.putItem(cosmetics)
            withContext(Dispatchers.Main) {
                view.showPostResponse(response)
            }
        }
    }

    fun postSmth(cosmetics: Cosmetics) {
        GlobalScope.launch {
            val response = model.postSmth(cosmetics)
            withContext(Dispatchers.Main) {
                view.showPostResponse(response)
            }
        }
    }

    fun getBlush() {
        GlobalScope.launch {
            val response = model.getBlush()
            withContext(Dispatchers.Main) {
                view.showGetResponse(response)
            }
        }
    }

    fun getLipstick() {
        GlobalScope.launch {
            val response = model.getLipstick()
            withContext(Dispatchers.Main) {
                view.showGetResponse(response)
            }
        }
    }

}