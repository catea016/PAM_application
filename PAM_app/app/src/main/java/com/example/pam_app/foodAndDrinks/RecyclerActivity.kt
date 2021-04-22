package com.example.pam_app.foodAndDrinks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_app.databinding.ActivityRecyclerBinding
import com.example.pam_app.foodAndDrinks.model.ModelFood
import com.example.pam_app.foodAndDrinks.presenter.PresenterFood
import com.example.pam_app.foodAndDrinks.utils.Food
import com.example.pam_app.foodAndDrinks.utils.FoodAdapter
import com.example.pam_app.foodAndDrinks.view.ViewFood
import java.util.*


class RecyclerActivity : AppCompatActivity(), ViewFood {

    private lateinit var binding: ActivityRecyclerBinding
    private lateinit var presenter: PresenterFood
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenter = PresenterFood(this, ModelFood())
        presenter.sendData()
    }

    override fun initRecyclerView(foodList: ArrayList<Food>) {
        presenter = PresenterFood(this, ModelFood())
        val recyclerView: RecyclerView = binding.recyclerView
        foodAdapter = FoodAdapter(foodList)
        val layoutManager = GridLayoutManager(applicationContext, 2);
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = foodAdapter

        recyclerView.adapter?.notifyDataSetChanged()
    }
}