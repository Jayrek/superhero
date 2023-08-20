package com.jrektabasa.superhero.presentation.viewmodel.hero

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.domain.model.HeroApi
import com.jrektabasa.superhero.domain.use_case.hero.FetchHeroApiByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroByIdViewModel @Inject constructor(
    private val useCase: FetchHeroApiByIdUseCase
) : ViewModel() {
    private val _hero = MutableStateFlow<Result<HeroApi>?>(null)
    val hero = _hero.asStateFlow()

    suspend fun getHeroInfo(id: String) {
        viewModelScope.launch {
            val response = useCase.execute(id)
            _hero.value = response
        }
    }
}