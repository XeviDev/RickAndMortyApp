package com.xevidev.rickandmortyapp.data

import com.xevidev.rickandmortyapp.data.core.CharactersService
import com.xevidev.rickandmortyapp.domain.model.Character
import com.xevidev.rickandmortyapp.domain.model.parseDomain
import javax.inject.Inject

class RickMortyRepository@Inject constructor(private val service: CharactersService) {

    suspend fun getCharactersList():List<Character>{
        val response = service.getCharactersList()
        return response.map { characterModel -> characterModel.parseDomain() }
    }

}