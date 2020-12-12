package com.basalam.test.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.basalam.test.R
import com.basalam.test.model.Data
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_layout.view.*



class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var myData = Data()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return myData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.text_row.text = myData[position].title
        val url = myData[position].thumbnailUrl + ".PNG";
        Log.d("IMAGES", url)
        Picasso.get().load(url).into(holder.itemView.image_row)

//        Glide.with(holder.itemView.context)
//            .load(url)
//            .into(holder.itemView.image_row)

    }

    fun setData(newList: Data) {
        myData = newList
        notifyDataSetChanged()

    }
}