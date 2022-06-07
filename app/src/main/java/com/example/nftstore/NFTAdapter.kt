package com.example.nftstore

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_container_nft.view.*

class NFTAdapter(val context: Context,private val nftList:List<LiveNFT>) : RecyclerView.Adapter<NFTAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_container_nft,parent,false)

        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model=nftList[position]
        holder.nftName.text=model.nftName
        holder.nftOwner.text="@${model.nftOwner}"
//        holder.liveTime.text=model.nftLiveTime
        Picasso.get().load(model.nftImageUrl).into(holder.nftImage)
    }

    override fun getItemCount(): Int = nftList.size

    class ViewHolder ( itemView: View):RecyclerView.ViewHolder(itemView){
        val nftImage=itemView.findViewById<ImageView>(R.id.nftImageView)
        val nftOwner=itemView.findViewById<TextView>(R.id.nftOwnerNameText)
        val nftName=itemView.findViewById<TextView>(R.id.nftNameText)
        val liveTime=itemView.findViewById<TextView>(R.id.liveTimeText)
    }

}