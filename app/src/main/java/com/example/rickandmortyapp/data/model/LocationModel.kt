package com.example.rickandmortyapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LocationModel(
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("url")
    @Expose
    val url: String
)
