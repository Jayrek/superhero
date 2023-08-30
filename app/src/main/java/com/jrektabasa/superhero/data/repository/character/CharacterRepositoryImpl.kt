package com.jrektabasa.superhero.data.repository.character

import com.jrektabasa.superhero.data.model.response.Character
import com.jrektabasa.superhero.data.remote.data_source.character.CharacterRemoteDataSource
import com.jrektabasa.superhero.domain.repository.character.CharacterRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(private val dataSource: CharacterRemoteDataSource) :
    CharacterRepository {
    override suspend fun getCharacter(): Character {
        return dataSource.getCharacter()
    }
}