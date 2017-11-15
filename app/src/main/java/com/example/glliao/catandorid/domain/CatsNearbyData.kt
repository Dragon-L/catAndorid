package com.example.glliao.catandorid.domain

import com.google.gson.annotations.SerializedName
import java.util.*

data class CatsNearbyData(@SerializedName("id") val id: String,
                          @SerializedName("cat") val name: String,
                          @SerializedName("avatar") val avatar: CatImage,
                          @SerializedName("timestamp") val updateTime: Date,
                          @SerializedName("message") val description: String,
                          @SerializedName("thumbs") val thumbsList: List<CatImage>)