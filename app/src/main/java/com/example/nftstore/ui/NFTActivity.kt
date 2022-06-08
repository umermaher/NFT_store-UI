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
        Picasso.get().load(imageUrl).into(nftImage)
    }
}