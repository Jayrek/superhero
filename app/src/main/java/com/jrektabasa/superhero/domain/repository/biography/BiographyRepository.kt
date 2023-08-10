package com.jrektabasa.superhero.domain.repository.biography

import com.jrektabasa.superhero.data.model.BiographyResponse

interface BiographyRepository {
    suspend fun getHeroBiography(id: String): BiographyResponse?
}