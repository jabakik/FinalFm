package com.example.finalfm.presentation.fmgenres

import com.example.finalfm.domain.models.genres.FmGenresResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel


sealed class UiState {
    class Loading : UiState ()
    data class Success(val data: FmGenresResponseModel) : UiState()
    data class Error(val throwable: Throwable) : UiState()
}