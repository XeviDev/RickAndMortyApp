package com.xevidev.rickandmortyapp.domain

import com.xevidev.rickandmortyapp.data.RickMortyRepository
import com.xevidev.rickandmortyapp.domain.model.CharacterDomain
import javax.inject.Inject

class CharactersUseCase@Inject constructor(private val repository: RickMortyRepository) {
    suspend operator fun invoke():List<CharacterDomain>{
        return repository.getCharactersList()
    }
}