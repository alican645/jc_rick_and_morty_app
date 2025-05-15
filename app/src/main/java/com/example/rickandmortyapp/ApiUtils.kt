package com.example.rickandmortyapp

import com.example.rickandmortyapp.data.interfaces.CharacterDaoInterface
import com.example.rickandmortyapp.data.interfaces.EpisodesDaoInterface
import com.example.rickandmortyapp.data.interfaces.LocationsDaoInterface

class ApiUtils {
    companion object{
        val BASE_URL = "https://rickandmortyapi.com/api/"

        fun getCharacterDaoInterface(): CharacterDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(CharacterDaoInterface::class.java)
        }

        fun getLocationsDaoInterface(): LocationsDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(LocationsDaoInterface::class.java)
        }

        fun getEpisodesDaoInterface(): EpisodesDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(EpisodesDaoInterface::class.java)

        }
    }
}