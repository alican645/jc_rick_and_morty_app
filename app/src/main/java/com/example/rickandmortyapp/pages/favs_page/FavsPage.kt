package com.example.rickandmortyapp.pages.favs_page

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.rickandmortyapp.ApiUtils
import com.example.rickandmortyapp.components.CharacterCard
import com.example.rickandmortyapp.components.LazyColumnForCharactersPage
import com.example.rickandmortyapp.data.model.CharacterModel
import com.example.rickandmortyapp.data.model.CharacterResponseModel
import com.example.rickandmortyapp.data.viewmodels.CharacterViewModel
import com.example.rickandmortyapp.ui.theme.Color1
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Response
import java.net.URLEncoder

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ViewModelConstructorInComposable")
@ExperimentalMaterial3Api

@Composable
fun FavsPage(navController: NavHostController) {
    val listState = rememberLazyListState()
    val vm = CharacterViewModel()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Rick And Morty") },
                actions = {
                    IconButton(onClick = {}) {
                        androidx.compose.material3.Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings", tint = Color1
                        )
                    }
                }
            )
        },
        content = {
            LazyColumnForCharactersPage(Modifier,listState ,vm.characterList, onCardPress = {
                val characterJsonData = URLEncoder.encode(Gson().toJson(it), "UTF-8")
                navController.navigate("characterDetail/$characterJsonData")})
        }
    )
}