package com.xevidev.rickandmortyapp.data.core

import com.xevidev.rickandmortyapp.data.models.CharactersModel
import retrofit2.Response
import retrofit2.http.GET

interface CharactersApiClient {

    @GET("character")
    suspend fun getCharacters(): Response<List<CharactersModel>>

}
