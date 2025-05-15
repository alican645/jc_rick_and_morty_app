package com.example.rickandmortyapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class InfoModel(
    @SerializedName("count")
    @Expose
    val count: Int?,
    @SerializedName("next")
    @Expose
    val next: String?,
    @SerializedName("pages")
    @Expose
    val pages: Int?,
    @SerializedName("prev")
    @Expose
    val prev: String?
)