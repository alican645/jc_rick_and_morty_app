package com.example.rickandmortyapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CharacterResponseModel(
    @SerializedName("info")
    @Expose
    val info: InfoModel,
    @SerializedName("results")
    @Expose
    val results: List<CharacterModel>
)




