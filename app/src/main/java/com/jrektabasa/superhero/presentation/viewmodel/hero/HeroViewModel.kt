package com.jrektabasa.superhero.presentation.viewmodel.hero

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jrektabasa.superhero.data.model.HeroResponse
import com.jrektabasa.superhero.domain.use_case.hero.FetchHeroListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HeroViewModel @Inject constructor(
    private val useCase: FetchHeroListUseCase
) : ViewModel() {
    //    private val _heroList = MutableStateFlow<List<HeroResponse>>(emptyList())
//    val heroList = MutableList<List<HeroResponse>>() = _heroList
    val users: StateFlow<List<HeroResponse>> = flow {
        val userList = useCase.getHeroList()
        emit(userList)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())


//    init {
//        viewModelScope.launch {
//            val response = useCase.getHeroList()
//        }
//    }
}