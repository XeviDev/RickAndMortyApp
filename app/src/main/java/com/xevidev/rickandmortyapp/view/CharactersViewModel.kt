package com.xevidev.rickandmortyapp.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xevidev.rickandmortyapp.domain.CharactersUseCase
import com.xevidev.rickandmortyapp.domain.model.CharacterDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: CharactersUseCase
) : ViewModel() {
//    val characters:StateFlow<List<CharacterDomain>> = MutableStateFlow(emptyList<CharacterDomain>())
//    private set
//    I wanted to use this, but its better with the other way
//    https://stackoverflow.com/questions/69735706/can-i-always-use-private-set-instead-of-private-val-in-kotlin

    private val _characters = MutableStateFlow(emptyList<CharacterDomain>())
    val characters: StateFlow<List<CharacterDomain>> = _characters

    fun getCharacters(){
        viewModelScope.launch {
            _characters.value = getCharactersUseCase()
        }
    }
}