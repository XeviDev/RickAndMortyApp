package com.xevidev.rickandmortyapp.data.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {

    fun retroFitProvider(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(rickAndMortyApiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    fun provideCharacterApiClient(retrofit: Retrofit):CharactersApiClient{
        return retrofit.create(CharactersApiClient::class.java)
    }

    companion object {
        private const val rickAndMortyApiUrl = "https://rickandmortyapi.com/api/"

    }
}