package com.example.pam_app.cosmetics

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pam_app.R

class RecyclerAdapter(val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var cosmeticsList : List<Cosmetics> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.cosmetics_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cosmeticsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.cosmeticName.text = cosmeticsList.get(position).name
        holder.cosmeticPrice.text = cosmeticsList.get(position).price.toString()
        Glide.with(context).load(cosmeticsList.get(position).image_link)
            .apply(RequestOptions().centerCrop())
            .into(holder.image)
    }

    fun setMovieListItems(movieList: List<Cosmetics>){
        this.cosmeticsList = movieList;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val image: ImageView = itemView!!.findViewById(R.id.item_photo)
        val cosmeticName: TextView = itemView!!.findViewById(R.id.item_title)
        val cosmeticPrice: TextView = itemView!!.findViewById(R.id.item_price)
    }
}