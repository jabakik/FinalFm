package com.example.finalfm.domain.repositories

import com.example.finalfm.domain.models.genres.FmGenresResponseModel
import kotlinx.coroutines.flow.Flow


interface FmGenresRepo {
    suspend fun getTopGenres(apiKey:String): Flow<FmGenresResponseModel>
}