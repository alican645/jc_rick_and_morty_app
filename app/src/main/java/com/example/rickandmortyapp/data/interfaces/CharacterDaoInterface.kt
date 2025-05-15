package com.example.rickandmortyapp.data.interfaces

import com.example.rickandmortyapp.data.model.CharacterModel
import com.example.rickandmortyapp.data.model.CharacterResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface CharacterDaoInterface {
    @GET("character")
    fun getAllCharacters(): Call<CharacterResponseModel>
}