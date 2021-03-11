package com.example.pam_app.foodAndDrinks
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_app.databinding.ListItemGridFoodBinding

internal class FoodAdapter(private var foodList: List<FoodModel>) : RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {

    private lateinit var binding: ListItemGridFoodBinding

    internal inner class MyViewHolder(binding: ListItemGridFoodBinding) : RecyclerView.ViewHolder(binding.root) {
        var image: ImageView = binding.imageFood
        var name: TextView = binding.textFoodName
        var price: TextView = binding.textPrice
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ListItemGridFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val food = foodList[position]
        food.getImage()?.let {
            holder.image.setImageResource(it)
        }
        holder.name.text = food.getName()
        holder.price.text = food.getPrice()
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}