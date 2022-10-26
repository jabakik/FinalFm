package com.example.finalfm.domain.repositories

import com.example.finalfm.domain.api.FmGenresService
import com.example.finalfm.domain.models.genres.FmGenresResponseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FmGenresRepolmpl @Inject constructor(val genresService: FmGenresService ):FmGenresRepo {
    override suspend fun getTopGenres(apiKey: String): Flow<FmGenresResponseModel> = flow {
        val fmResponse = genresService.getTopFmCategory(apiKey = apiKey).body()
        emit(fmResponse!!)
    }

}