package com.example.rickandmortyapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CharacterModel(
    @SerializedName("created")
    @Expose
    val created: String,
    @SerializedName("episode")
    @Expose
    val episode: List<String>,
    @SerializedName("gender")
    @Expose
    val gender: String,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("image")
    @Expose
    val image: String,
    @SerializedName("location")
    @Expose
    val location: LocationModel,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("origin")
    @Expose
    val origin: OriginModel,
    @SerializedName("species")
    @Expose
    val species: String,
    @SerializedName("status")
    @Expose
    val status: String,
    @SerializedName("type")
    @Expose
    val type: String,
    @SerializedName("url")
    @Expose
    val url: String
)



