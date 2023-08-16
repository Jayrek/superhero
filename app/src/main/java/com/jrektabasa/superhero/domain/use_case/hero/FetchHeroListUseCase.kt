package com.jrektabasa.superhero.domain.use_case.hero

import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.domain.model.Hero
import com.jrektabasa.superhero.domain.repository.HeroRepository
import javax.inject.Inject

class FetchHeroListUseCase @Inject constructor(
    private val repository: HeroRepository
) {

    suspend fun execute(): Result<List<Hero>> = repository.getHeroList()
}