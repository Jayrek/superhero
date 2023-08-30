package com.jrektabasa.superhero.presentation.viewmodel.hero

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.data.model.response.Character
import com.jrektabasa.superhero.domain.model.Hero
import com.jrektabasa.superhero.domain.repository.character.CharacterRepository
import com.jrektabasa.superhero.domain.use_case.hero.FetchHeroListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroViewModel @Inject constructor(
    private val useCase: FetchHeroListUseCase,
    private val characterRepository: CharacterRepository
) : ViewModel() {
    private val _heroList = MutableStateFlow<Result<List<Hero>>?>(null)
    val heroList: StateFlow<Result<List<Hero>>?> = _heroList

    private val _characterList = MutableStateFlow<Character?>(null)
    val characterList = _characterList.asStateFlow()

    init {
//        viewModelScope.launch {
//            val response = useCase.execute()
//            _heroList.value = response
//        }

        viewModelScope.launch {
            val response = characterRepository.getCharacter()
            _characterList.value = response
        }
    }
}