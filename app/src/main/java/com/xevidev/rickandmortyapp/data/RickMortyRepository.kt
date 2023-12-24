package com.xevidev.rickandmortyapp.data

import com.xevidev.rickandmortyapp.data.core.CharactersService
import com.xevidev.rickandmortyapp.data.models.CharactersModel
import com.xevidev.rickandmortyapp.domain.model.CharacterDomain
import com.xevidev.rickandmortyapp.domain.model.parseDomain
import javax.inject.Inject

class RickMortyRepository@Inject constructor(private val service: CharactersService) {

    suspend fun getCharactersList():List<CharacterDomain>{
        val response:List<CharactersModel> = service.getCharactersList()
        return response.map {
                characterModel -> characterModel.parseDomain()
        }
    }

}