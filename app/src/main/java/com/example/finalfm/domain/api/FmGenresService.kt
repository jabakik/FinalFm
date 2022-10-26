package com.example.finalfm.domain.api

import com.example.finalfm.domain.models.genres.FmGenresResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FmGenresService {
    @GET("2.0/")
    suspend fun getTopFmCategory(
        @Query("method") method:String = "tag.getTopTags",
        @Query("api_key") apiKey:String,
        @Query("format") format: String = "json"
    ): Response<FmGenresResponseModel>
}