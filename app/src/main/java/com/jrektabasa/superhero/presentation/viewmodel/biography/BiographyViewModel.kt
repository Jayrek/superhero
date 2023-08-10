package com.jrektabasa.superhero.presentation.viewmodel.biography

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jrektabasa.superhero.data.model.BiographyResponse
import com.jrektabasa.superhero.domain.repository.biography.BiographyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BiographyViewModel @Inject constructor(
    private val repository: BiographyRepository
) : ViewModel() {

    private val _biography = MutableStateFlow<BiographyResponse?>(null)
    val biography: StateFlow<BiographyResponse?> = _biography

    init {
        viewModelScope.launch {
            val response = repository.getHeroBiography("30")
            _biography.value = response
        }
    }

    suspend fun getHeroBiography(id: String) {
        viewModelScope.launch {
            repository.getHeroBiography(id)
        }
    }
}