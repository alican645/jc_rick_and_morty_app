package com.example.rickandmortyapp.data.interfaces

import com.example.rickandmortyapp.data.model.CharacterResponseModel
import com.example.rickandmortyapp.data.model.EpisodeResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface EpisodesDaoInterface {
    @GET("episode")
    fun getAllEpisodes(): Call<EpisodeResponseModel>
}