package com.example.pam_app.foodAndDrinks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_app.R
import com.example.pam_app.databinding.ActivityRecyclerBinding


class RecyclerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerBinding

    private val foodList = ArrayList<FoodModel>()
    private lateinit var foodAdapter: FoodAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val recyclerView: RecyclerView = binding.recyclerView
        foodAdapter = FoodAdapter(foodList)
        val layoutManager = GridLayoutManager(applicationContext, 2);
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = foodAdapter
        prepareData()
    }

    private fun prepareData() {
        var food = FoodModel(R.drawable.carbonara, "Carbonara", "80 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.lavnda_cake_69mdl, " Lavanda Cake", "69 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.pizza_130mdl, "Pizza Set", "130 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.happy_picnic_400mdl, "Happy Picnic", "400 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.fresh_vegetables_150mdl, "Fresh Vegetables", "150 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.grilled_vegetables_150mdl, "Grilled Vegetables", "150 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.purcari_sauvignon_blank_156mdl, "Purcari Sauvignon Blank", "156 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.oatmeal_with_fruits_43mdl, "Oatmeal with fruits", "43 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.corn_soup_58mdl, "Corn Soup", "58 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.meat_platter_300md, "Meat Platter", "300 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.tuna_salad_70mdl, "Tuna Salad", "70 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.fruit_plate, "Fruit Plate", "160 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.ravioli_76mdll, "Ravioli", "76 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.spinach_cream_soup_112mdl, "Spinach Cream-Soup", "112 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.omelette_39mdl, "Omelette", "39 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.homemade_red_whine_94, "Homemade red whine", "94 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.fresh_51mdl, "Fresh", "51 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.dorna_35mdl, "Dorna", "35 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.tiramisu_57mdl, "Tiramisu", "57 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.cheesecake_65mdl, "Cheesecake", "65 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.fruid_salad_44mdl, "Fruit salad", "44 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.ravioli_76mdll, "Ravioli", "76 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.spinach_cream_soup_112mdl, "Spinach Cream-Soup", "112 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.omelette_39mdl, "Omelette", "39 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.homemade_red_whine_94, "Homemade red whine", "94 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.fresh_51mdl, "Fresh", "51 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.dorna_35mdl, "Dorna", "35 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.corn_soup_58mdl, "Corn Soup", "58 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.lavnda_cake_69mdl, " Lavanda Cake", "69 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.pizza_130mdl, "Pizza Set", "130 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.happy_picnic_400mdl, "Happy Picnic", "400 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.fresh_vegetables_150mdl, "Fresh Vegetables", "150 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.grilled_vegetables_150mdl, "Grilled Vegetables", "150 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.purcari_sauvignon_blank_156mdl, "Purcari Sauvignon Blank", "156 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.oatmeal_with_fruits_43mdl, "Oatmeal with fruits", "43 MDL")
        foodList.add(food)
        food = FoodModel(R.drawable.corn_soup_58mdl, "Corn Soup", "58 MDL")
        foodList.add(food)
        foodAdapter.notifyDataSetChanged()
    }
}