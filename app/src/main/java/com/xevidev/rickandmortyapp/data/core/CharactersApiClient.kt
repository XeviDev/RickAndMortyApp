package com.xevidev.rickandmortyapp.data.core

import com.xevidev.rickandmortyapp.data.CharactersModel
import retrofit2.Response
import retrofit2.http.GET

interface CharactersApiClient {

    @GET("characters")
    fun getCharacters(): Response<List<CharactersModel>>

}
