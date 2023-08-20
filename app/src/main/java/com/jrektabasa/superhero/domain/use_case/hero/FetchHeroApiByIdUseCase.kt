package com.jrektabasa.superhero.domain.use_case.hero

import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.domain.model.HeroApi
import com.jrektabasa.superhero.domain.repository.HeroRepository
import javax.inject.Inject

class FetchHeroApiByIdUseCase @Inject constructor(
    private val repository: HeroRepository
) {

    suspend fun execute(id: String): Result<HeroApi> {
        return repository.getHeroById(id)
    }
}