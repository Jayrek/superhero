package com.jrektabasa.superhero.domain.repository.character

import com.jrektabasa.superhero.data.model.response.Character

interface CharacterRepository{
    suspend fun getCharacter(): Character
}