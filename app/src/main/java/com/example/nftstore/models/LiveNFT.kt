package com.example.nftstore.models

data class LiveNFT(
    val nftName:String?=null,
    val nftImageUrl:String?=null,
    val nftOwner:String?=null,
    val nftLiveTime:String?=null,
    val about:String?=null,
    val history:String?=null,
    val owners:String?=null,
    val price:String?=null
)