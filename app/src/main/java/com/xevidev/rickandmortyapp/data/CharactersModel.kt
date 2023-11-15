package com.xevidev.rickandmortyapp.data

import com.google.gson.annotations.SerializedName

data class CharactersModel(
    @SerializedName("id")val id: Int,
    @SerializedName("name")val name: String,
    @SerializedName("status")val status: String,
    @SerializedName("species")val species: String,
    @SerializedName("image")val image: String
)
