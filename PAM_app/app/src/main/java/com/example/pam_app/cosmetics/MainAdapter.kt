package com.example.pam_app.cosmetics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pam_app.R


class MainAdapter : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    private var myList = emptyList<Cosmetics>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView!!.findViewById(R.id.item_photo)
        val cosmeticName: TextView = itemView!!.findViewById(R.id.item_title)
        val cosmeticPrice: TextView = itemView!!.findViewById(R.id.item_price)

        fun bind(item: Cosmetics) {
            itemView.apply {
                cosmeticName.text = item.name
                cosmeticPrice.text = item.price.toString()
                Glide.with(image.context)
                    .load(item.image_link)
                    .into(image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cosmetics_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(myList[position])
    }

    fun setData(newList: List<Cosmetics>) {
        myList = newList
        notifyDataSetChanged()
    }
}