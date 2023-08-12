package com.jrektabasa.superhero.domain.use_case.hero

import com.jrektabasa.superhero.data.model.HeroResponse
import com.jrektabasa.superhero.domain.repository.HeroRepository
import javax.inject.Inject

class FetchHeroListUseCase @Inject constructor(
    private val repository: HeroRepository
) {

    suspend fun getHeroList(): List<HeroResponse> {
        return repository.getHeroList()
    }
}