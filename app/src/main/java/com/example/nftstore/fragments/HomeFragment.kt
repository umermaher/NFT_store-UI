package com.example.nftstore.fragments

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.nftstore.NFTAdapter
import com.example.nftstore.NewCollectionAdapter
import com.example.nftstore.R
import com.example.nftstore.databinding.FragmentHomeBinding
import com.example.nftstore.models.LiveNFT
import com.example.nftstore.models.NewCollection
import com.example.nftstore.ui.NFTActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_profile_picture.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding!!


    private val nftList=ArrayList<LiveNFT>()
    private val newCollectionList=ArrayList<NewCollection>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        addItemsNFTs()
        addItemsNewCollections()

        val adapter= NFTAdapter(requireContext(),nftList,createOnNftClickListener())

        binding.nftViewPager.adapter=adapter
        binding.nftViewPager.clipToPadding=false
        binding.nftViewPager.clipChildren=false
        binding.nftViewPager.offscreenPageLimit=3
        binding.nftViewPager.getChildAt(0).overScrollMode=RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer=CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer { page, position ->
            val r:Float=1-Math.abs(position)
            page.scaleY=0.95f+r*0.05f
        }
        binding.nftViewPager.setPageTransformer(compositePageTransformer)

        val newCollectionAdapter=NewCollectionAdapter(newCollectionList)
        binding.rvNewCollections.layoutManager=LinearLayoutManager(requireContext())
        binding.rvNewCollections.setHasFixedSize(true)
        binding.rvNewCollections.adapter=newCollectionAdapter

        return binding.root
    }

    private fun createOnNftClickListener()=object : NFTAdapter.OnClickListener{
        override fun onClick(position: Int, cardView: CardView) {
            val intent = Intent(activity, NFTActivity::class.java)
            val nft=nftList[position]
            intent.putExtra("nftName",nft.nftName)
            intent.putExtra("nftImageUrl",nft.nftImageUrl)
            intent.putExtra("nftOwners",nft.owners)
            intent.putExtra("nftLiveTime",nft.nftLiveTime)
            intent.putExtra("nftAbout",nft.about)
            intent.putExtra("nftHistory",nft.history)
            intent.putExtra("nftPrice",nft.price)
//            startActivity(intent)
            val pair= arrayOf(
                Pair<View,String>(cardView,getString(R.string.nft_image_tran))
            )

            val options= ActivityOptions.makeSceneTransitionAnimation(requireActivity(),*pair)
            startActivity(intent,options.toBundle())
        }

    }

    private fun addItemsNewCollections() {
        newCollectionList.add(
            NewCollection(
                "https://assets.entrepreneur.com/content/3x2/2000/1647618774-ape-nft.jpg?auto=webp&quality=95&crop=16:9&width=675",
                getString(R.string.exampleText)
            )
        )
        newCollectionList.add(
            NewCollection(
                "https://lh3.googleusercontent.com/LJOjfIyAWQgx5NTHw1kI3-w2wge2y6JjPWDr8B-_WcCeJ6HmcyjNwdAF5SA8xC-LWKoX2tKdIFv_2K7iowUqbn0hdFf3lgzfH6JOzKQ=w600",
                getString(R.string.exampleText)
            )
        )
    }

    private fun addItemsNFTs() {
        nftList.add(
            LiveNFT(
                "MONKEY GANG",
                "https://public.nftstatic.com/static/nft/res/b2635abfc19d4df481b525ff55066ca3.jpeg",
                "PleaseHelpMeee",
                "",
                "say hello to the monkey gang they are so impatient only 1000 unique By Hestiart",
                "xvz",
                "PleaseHelpMeee",
                "110",
            )
        )
        nftList.add(
            LiveNFT(
                "Happy Man",
                "https://public.nftstatic.com/static/nft/res/de7cfdf9f8234d179ac96539d1f0d321.jpeg",
                "pancakeart",
                "",
                "Happy Man #87 34/50 (N) Laughter roams the Metaverse. Everyone talks about a different appearance about the owner of this Laughter. Have you ever heard of this Laughter? If you have heard, the owner of this Laughter is definitely ''Happy Man''. Because he is the happiest person in the entire Metaverse and digitaly coded to keep its new owner happy. Rarity: N Total Supply: 3333 NFTs Unique: 99 Happy Man NFT Size: 2048x2048 Pixels",
                "xvz",
                "pancakeart",
                "230",
            )
        )
        nftList.add(
            LiveNFT(
                "Bored MONKEY",
                "https://public.nftstatic.com/static/nft/res/ee1801772a344d528f01327d6f6cd212.png",
                "Sellavi1",
                "",
                "MonkeyCash DYOR is an exclusive NFT collection of 4,200 unique tokens dedicated to the game \"MonkeyCash\". Buy a monkey and it will mine cryptocurrency for you. Discord: @dBKZuRKBSg Twitter: @monkeyhypenft TG: @monkeyhypenft",
                "xvz",
                "Sellavi1",
                "270",
            )
        )
    }
}
