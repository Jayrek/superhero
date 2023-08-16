package com.jrektabasa.superhero.presentation.viewmodel.hero

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.domain.model.Hero
import com.jrektabasa.superhero.domain.use_case.hero.FetchHeroListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroViewModel @Inject constructor(
    private val useCase: FetchHeroListUseCase
) : ViewModel() {
    private val _heroList = MutableStateFlow<Result<List<Hero>>?>(null)
    val heroList: StateFlow<Result<List<Hero>>?> = _heroList

    init {
        viewModelScope.launch {
            val response = useCase.execute()
            _heroList.value = response
        }
    }
}