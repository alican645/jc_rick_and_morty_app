package com.example.rickandmortyapp.data.viewmodels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.ApiUtils
import com.example.rickandmortyapp.data.model.CharacterModel
import com.example.rickandmortyapp.data.model.CharacterResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel : ViewModel() {
    private val characterDaoInterface = ApiUtils.getCharacterDaoInterface()


    private val _characters =  mutableStateListOf<CharacterModel>()
    private val _searchParameter = mutableStateOf("")

    val characterList = _characters;
    val searchParameter = _searchParameter;
    init {
        loadCharacters()
    }

    fun loadCharacters() {
        Log.i("CharactersPage", "loadCharacters çalıştı")
        characterDaoInterface.getAllCharacters()
            .enqueue(object : Callback<CharacterResponseModel> {
                override fun onResponse(
                    call: Call<CharacterResponseModel?>,
                    response: Response<CharacterResponseModel?>,
                ) {

                    for (i in response.body()!!.results) {
                        _characters.add(i)
                    }
                }

                override fun onFailure(
                    call: Call<CharacterResponseModel?>,
                    t: Throwable,
                ) {Log.i("CharactersPage", t.message.toString())}

            })

    }

    fun clearCharacters() {
        _characters.clear()
    }

    fun addAll(characters: List<CharacterModel>) {
        _characters.addAll(characters)
    }

    fun searchCharacter(searchParameter: String,context: Context){
        try {
            val characterDaoInterface = ApiUtils.getCharacterDaoInterface()
            characterDaoInterface.getCharactersByName(searchParameter)
                .enqueue(object : Callback<CharacterResponseModel> {
                    override fun onResponse(
                        call: Call<CharacterResponseModel?>,
                        response: Response<CharacterResponseModel?>,
                    ) {
                        clearCharacters()
                        val results = response.body()?.results
                        if (!results.isNullOrEmpty()) {
                            addAll(results)
                        } else {

                            Toast.makeText(context, "Sonuç bulunamadı", Toast.LENGTH_SHORT).show()
                        }
                    }



                    override fun onFailure(
                        call: Call<CharacterResponseModel?>,
                        t: Throwable,
                    ) {
                        clearCharacters()

                    }

                })
        } catch (e: Exception) {
            Log.e("ErrorCharactersPage", e.message.toString())
        }
    }
}
