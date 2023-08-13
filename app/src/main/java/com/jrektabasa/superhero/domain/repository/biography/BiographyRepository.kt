package com.jrektabasa.superhero.domain.repository.biography

import com.jrektabasa.superhero.domain.model.Biography

interface BiographyRepository {
    suspend fun getHeroBiography(id: String): Biography?
}