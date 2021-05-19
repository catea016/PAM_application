package com.example.pam_app.cosmetics.presenter

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.pam_app.cosmetics.api.Cosmetics
import com.example.pam_app.cosmetics.api.MainAdapter
import com.example.pam_app.cosmetics.model.Model
import com.example.pam_app.cosmetics.view.View
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class Presenter(private val view: View, private val model: Model, private val context: Context, private val adapter: MainAdapter) {

    fun initView() {
        view.init()
    }

    fun putItem(cosmetics: Cosmetics) {
        GlobalScope.launch {
            val response = model.putItem(cosmetics)
            withContext(Dispatchers.Main) {
                showPostResponse(response, context)
            }
        }
    }

    fun postSmth(cosmetics: Cosmetics) {
        GlobalScope.launch {
            val response = model.postSmth(cosmetics)
            withContext(Dispatchers.Main) {
                showPostResponse(response, context)
            }
        }
    }

    fun getBlush() {
        GlobalScope.launch {
            val response = model.getBlush()
            withContext(Dispatchers.Main) {
                showGetResponse(response, context)
            }
        }
    }

    fun getLipstick() {
        GlobalScope.launch {
            val response = model.getLipstick()
            withContext(Dispatchers.Main) {
                showGetResponse(response, context)
            }
        }
    }

     fun showGetResponse(response: Response<List<Cosmetics>>, context: Context) {
        if (response.isSuccessful) {
            response.body()?.let { adapter.setData(it) }
            println("successful")
        } else {
            Toast.makeText(context, response.code().toString(), Toast.LENGTH_SHORT).show()
            println("unsuccessful GET")
        }
    }

     fun showPostResponse(response: Response<Cosmetics>, context: Context) {
        if (response.isSuccessful) {
            println("successful")
            Log.d("Main", response.body().toString())
            Log.d("Main", response.code().toString())
            Log.d("Main", response.message())
        } else {
            println("unsuccessful POST request - doesn't have the access to the api")
            Toast.makeText(context, response.code().toString(), Toast.LENGTH_SHORT).show()
        }
    }

}