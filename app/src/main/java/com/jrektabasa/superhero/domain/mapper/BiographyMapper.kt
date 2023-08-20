package com.jrektabasa.superhero.domain.mapper

import com.jrektabasa.superhero.data.model.response.BiographyResponse
import com.jrektabasa.superhero.domain.model.Biography
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BiographyMapper @Inject constructor() {

    // TODO should have a separate mapper for the mapToDomain object and list function
    fun mapToDomain(response: BiographyResponse): Biography {
        return Biography(
//            response.id,
//            response.response,
//            response.name,
            response.fullName,
            response.alterEgos,
            response.aliases,
            response.placeOfBirth,
            response.firstAppearance,
            response.publisher,
            response.alignment,
        )
    }

    fun mapToDomain(responseList: List<BiographyResponse>): List<Biography> {
        return responseList.map { mapToDomain(it) }
    }
}