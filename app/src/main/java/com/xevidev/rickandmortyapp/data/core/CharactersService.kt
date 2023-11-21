package com.xevidev.rickandmortyapp.data.core

import com.xevidev.rickandmortyapp.data.models.CharactersModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharactersService @Inject constructor(private val apiClient: CharactersApiClient) {
    suspend fun getCharactersList(): List<CharactersModel> {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getCharacters()
            response.body()?.result?: emptyList()
        }
    }
}