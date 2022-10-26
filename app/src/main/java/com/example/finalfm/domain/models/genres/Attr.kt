package com.example.finalfm.domain.models.genres


import com.google.gson.annotations.SerializedName

data class Attr(
    @SerializedName("num_res")
    val numRes: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("total")
    val total: Int
)