package com.example.finalfm.domain.models.genres


import com.google.gson.annotations.SerializedName

data class Toptags(
    @SerializedName("@attr")
    val attr: Attr,
    @SerializedName("tag")
    val tag: List<Tag>
)