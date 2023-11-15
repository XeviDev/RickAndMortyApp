package com.xevidev.rickandmortyapp.data.core

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Network {

    @Singleton
    @Provides
    fun retroFitProvider(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(rickAndMortyApiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Singleton
    @Provides
    fun provideCharacterApiClient(retrofit: Retrofit):CharactersApiClient{
        return retrofit.create(CharactersApiClient::class.java)
    }

    companion object {
        private const val rickAndMortyApiUrl = "https://rickandmortyapi.com/api/"

    }
}