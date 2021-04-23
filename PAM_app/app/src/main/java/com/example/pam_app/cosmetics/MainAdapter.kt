package com.example.pam_app.cosmetics

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pam_app.databinding.CosmeticsItemBinding


class MainAdapter : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    private var myList = emptyList<Cosmetics>()

    inner class MyViewHolder(binding: CosmeticsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val image: ImageView = binding.itemPhoto
        val cosmeticName: TextView = binding.itemTitle
        val cosmeticPrice: TextView = binding.itemPrice

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
        val binding =
            CosmeticsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
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