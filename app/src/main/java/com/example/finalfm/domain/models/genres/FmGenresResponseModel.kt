package com.example.finalfm.domain.models.genres


import com.google.gson.annotations.SerializedName

data class FmGenresResponseModel(
    @SerializedName("toptags")
    val toptags: Toptags
)