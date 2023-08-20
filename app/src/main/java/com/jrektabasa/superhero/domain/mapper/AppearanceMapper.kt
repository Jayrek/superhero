package com.jrektabasa.superhero.domain.mapper

import com.jrektabasa.superhero.data.model.response.AppearanceResponse
import com.jrektabasa.superhero.domain.model.Appearance
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppearanceMapper @Inject constructor() {

    fun mapToDomain(response: AppearanceResponse): Appearance {
        return Appearance(
            response.eyeColor,
            response.gender,
            response.hairColor,
            response.height,
            response.race,
            response.weight,
        )
    }
}