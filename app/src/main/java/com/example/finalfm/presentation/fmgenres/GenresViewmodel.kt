package com.example.finalfm.presentation.fmgenres

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalfm.domain.api.FmGenresService
import com.example.finalfm.domain.repositories.FmGenresRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class GenresViewmodel @Inject constructor(private val categoryRepo: FmGenresRepo ):ViewModel() {
    private val categoryStateFlow = MutableStateFlow<UiState>(UiState.Loading())
    val uiState:StateFlow<UiState> = categoryStateFlow
    init {
        viewModelScope.launch{
            categoryRepo.getTopGenres("8a0e338471e81bb0dffeaa37600d414b")
                .catch {
                    categoryStateFlow.value = UiState.Error(throwable = it)
                }
                .collectLatest { response ->
                    categoryStateFlow.value = UiState.Success(data = response)
                }
        }
    }
}