package com.example.rickandmortyapp.data.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.ApiUtils
import com.example.rickandmortyapp.data.model.EpisodeModel
import com.example.rickandmortyapp.data.model.EpisodeResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeViewModel : ViewModel() {
    private val episodesDaoInterface = ApiUtils.getEpisodesDaoInterface()


    private val _episodesList  =  mutableStateListOf<EpisodeModel>()


    val episodesList = _episodesList;
    init {
        loadEpisodes()
    }

    fun loadEpisodes() {
        Log.i("EpisodePage", "loadEpisodes çalıştı")
        episodesDaoInterface.getAllEpisodes()
            .enqueue(object : Callback<EpisodeResponseModel> {
                override fun onResponse(
                    call: Call<EpisodeResponseModel?>,
                    response: Response<EpisodeResponseModel?>,
                ) {

                    for (i in response.body()!!.results) {
                        _episodesList.add(i)
                    }
                }

                override fun onFailure(
                    call: Call<EpisodeResponseModel?>,
                    t: Throwable,
                ) {Log.i("EpisodePage", t.message.toString())}

            })

    }




}
