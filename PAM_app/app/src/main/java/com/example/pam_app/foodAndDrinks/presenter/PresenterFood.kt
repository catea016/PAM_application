package com.example.pam_app.foodAndDrinks.presenter

import com.example.pam_app.foodAndDrinks.model.ModelFood
import com.example.pam_app.foodAndDrinks.view.ViewFood

class PresenterFood(private val view: ViewFood, private val modelFood: ModelFood) {
    fun sendData() {
        view.initRecyclerView(modelFood.prepareData())
    }
}