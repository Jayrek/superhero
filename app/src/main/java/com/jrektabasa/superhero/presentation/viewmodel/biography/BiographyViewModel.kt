package com.jrektabasa.superhero.presentation.viewmodel.biography

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.domain.model.Biography
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

    private val _biography = MutableStateFlow<Result<Biography>?>(null)
    val biography: StateFlow<Result<Biography>?> = _biography

//    init {
//        viewModelScope.launch {
//            val response = repository.getHeroBiography("30")
//            _biography.value = response
//        }
//    }

    suspend fun getHeroBiography(id: String) {
        viewModelScope.launch {
           val response = repository.getHeroBiography(id)
            _biography.value = response
        }
    }
}