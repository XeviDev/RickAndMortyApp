package com.xevidev.rickandmortyapp.data

import com.xevidev.rickandmortyapp.data.models.CharactersModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RickMortyRepository {
    suspend fun getCharactersList(): List<CharactersModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getCharacters()
            response.body()?: emptyList()
        }
    }
}