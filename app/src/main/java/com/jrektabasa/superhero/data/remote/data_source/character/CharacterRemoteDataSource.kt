package com.jrektabasa.superhero.data.remote.data_source.character

import com.jrektabasa.superhero.data.model.response.Character

interface CharacterRemoteDataSource {

    suspend fun getCharacter(): Character
}