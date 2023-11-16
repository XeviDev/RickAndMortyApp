package com.xevidev.rickandmortyapp.domain.model

import android.os.Parcelable
import com.xevidev.rickandmortyapp.data.models.CharactersModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterDomain(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val image: String
) : Parcelable

fun CharactersModel.parseDomain() = CharacterDomain(id, name, status, species, image)
