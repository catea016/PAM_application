package com.example.pam_app.foodAndDrinks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_app.R


class RecyclerActivity : AppCompatActivity() {
    private val foodList = ArrayList<FoodModel>()
    private lateinit var foodAdapter: FoodAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        foodAdapter = FoodAdapter(foodList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = foodAdapter
        prepareData()
    }

    private fun prepareData() {
        var food = FoodModel("@drawable/carbonara", "Carbonara", "80 MDL")
        foodList.add(food)
        foodAdapter.notifyDataSetChanged()
    }
}