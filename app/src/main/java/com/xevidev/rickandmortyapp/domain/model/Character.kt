package com.xevidev.rickandmortyapp.domain.model

import com.google.gson.annotations.SerializedName

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val image: String
)
