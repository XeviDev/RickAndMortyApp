package com.xevidev.rickandmortyapp.data.models

import com.google.gson.annotations.SerializedName

data class ResultModel(
    @SerializedName("results") val result:List<CharactersModel>
)
