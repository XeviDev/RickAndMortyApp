package com.xevidev.rickandmortyapp.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class OriginModel(
    @SerializedName("name") val name:String,
    @SerializedName("url") val url:String,
): Serializable
