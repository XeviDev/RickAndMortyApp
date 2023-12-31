package com.xevidev.rickandmortyapp.domain.model

import android.os.Parcelable
import com.xevidev.rickandmortyapp.data.models.CharactersModel
import com.xevidev.rickandmortyapp.data.models.LocationModel
import com.xevidev.rickandmortyapp.data.models.OriginModel
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class CharacterDomain(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val image: String,
    val location: @RawValue LocationModel,
    val origin: @RawValue OriginModel
) : Parcelable

fun CharactersModel.parseDomain() =
    CharacterDomain(id, name, status, species, image, location, origin)
