package com.example.nftstore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nftstore.models.NewCollection
import com.squareup.picasso.Picasso

class NewCollectionAdapter(private val newCollections:List<NewCollection>): RecyclerView.Adapter<NewCollectionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.new_collection_item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model=newCollections[position]
        Picasso.get().load(model.imageUrl).into(holder.image)
        holder.text.text=model.details
    }

    override fun getItemCount(): Int = newCollections.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.newCollectionImage)
        val text: TextView = itemView.findViewById(R.id.newCollectionText)
    }
}