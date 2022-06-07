package com.example.nftstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    private val nftList=ArrayList<LiveNFT>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_home, container, false)

        addItemsNFTs()
        val adapter=NFTAdapter(requireContext(),nftList)
        view.nftViewPager.adapter=adapter
        view.nftViewPager.clipToPadding=false
        view.nftViewPager.clipChildren=false
        view.nftViewPager.offscreenPageLimit=3
        view.nftViewPager.getChildAt(0).overScrollMode=RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer=CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer { page, position ->
            val r:Float=1-Math.abs(position)
            page.scaleY=0.95f+r*0.05f
        }

        view.nftViewPager.setPageTransformer(compositePageTransformer)
        return view
    }

    private fun addItemsNFTs() {
        nftList.add(LiveNFT("MONKEY GANG",
            "https://public.nftstatic.com/static/nft/res/b2635abfc19d4df481b525ff55066ca3.jpeg",
            "PleaseHelpMeee",
            "",
            "say hello to the monkey gang they are so impatient only 1000 unique By Hestiart",
            "xvz",
            "PleaseHelpMeee",
            "110",
        ))
        nftList.add(LiveNFT("Happy Man",
            "https://public.nftstatic.com/static/nft/res/de7cfdf9f8234d179ac96539d1f0d321.jpeg",
            "pancakeart",
            "",
            "Happy Man #87 34/50 (N) Laughter roams the Metaverse. Everyone talks about a different appearance about the owner of this Laughter. Have you ever heard of this Laughter? If you have heard, the owner of this Laughter is definitely ''Happy Man''. Because he is the happiest person in the entire Metaverse and digitaly coded to keep its new owner happy. Rarity: N Total Supply: 3333 NFTs Unique: 99 Happy Man NFT Size: 2048x2048 Pixels",
            "xvz",
            "pancakeart",
            "230",
        ))
        nftList.add(LiveNFT("Bored MONKEY",
            "https://public.nftstatic.com/static/nft/res/ee1801772a344d528f01327d6f6cd212.png",
            "Sellavi1",
            "",
            "MonkeyCash DYOR is an exclusive NFT collection of 4,200 unique tokens dedicated to the game \"MonkeyCash\". Buy a monkey and it will mine cryptocurrency for you. Discord: @dBKZuRKBSg Twitter: @monkeyhypenft TG: @monkeyhypenft",
            "xvz",
            "Sellavi1",
            "270",
        ))
    }
}