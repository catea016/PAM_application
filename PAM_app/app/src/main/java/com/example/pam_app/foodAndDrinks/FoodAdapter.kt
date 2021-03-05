package com.example.pam_app.foodAndDrinks
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_app.R

internal class FoodAdapter(private var foodList: List<FoodModel>) : RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView = view.findViewById(R.id.imageFood)
        var name: TextView = view.findViewById(R.id.textFoodName)
        var price: TextView = view.findViewById(R.id.textPrice)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_grid_food, parent, false)

        return MyViewHolder(itemView)
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