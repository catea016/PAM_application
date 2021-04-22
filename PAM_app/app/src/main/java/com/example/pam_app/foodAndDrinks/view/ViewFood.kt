package com.example.pam_app.foodAndDrinks.view

import com.example.pam_app.foodAndDrinks.utils.Food
import java.util.*

interface ViewFood {
    fun initRecyclerView(food: ArrayList<Food>)
}
