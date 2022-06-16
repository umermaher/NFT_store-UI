package com.example.nftstore.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nftstore.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_nftactivity.*

class NFTActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nftactivity)

        val imageUrl=intent.getStringExtra("nftImageUrl")
        val nftName=intent.getStringExtra("nftName")
        val nftOwner=intent.getStringExtra("nftOwner")
        val nftAbout=intent.getStringExtra("nftAbout")
        val nftPrice=intent.getStringExtra("nftPrice")

        Picasso.get().load(imageUrl).into(nftImage)
        priceText.text=nftPrice
        nftNameText.text=nftName
        AtTheRateNftOwnerText.text="@$nftOwner"
        nftOwnerText.text=nftOwner
        aboutText.text=nftAbout
    }
}