package com.jrektabasa.superhero.domain.model

import com.jrektabasa.superhero.data.model.response.WorkResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WorkMapper @Inject constructor() {

    fun mapToDomain(response: WorkResponse): Work {
        return Work(
            response.base,
            response.occupation
        )
    }
}