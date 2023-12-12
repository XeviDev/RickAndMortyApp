package com.xevidev.rickandmortyapp.data.models

import com.google.gson.annotations.SerializedName

data class CharactersModel(
    @SerializedName("id")val id: Int,
    @SerializedName("name")val name: String,
    @SerializedName("status")val status: String,
    @SerializedName("species")val species: String,
    @SerializedName("image")val image: String,
    @SerializedName("location") val location:LocationModel
)
