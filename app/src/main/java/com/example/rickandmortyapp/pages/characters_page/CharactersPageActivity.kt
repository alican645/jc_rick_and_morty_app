package com.example.rickandmortyapp.pages.characters_page


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.rickandmortyapp.components.CharacterCard
import com.example.rickandmortyapp.components.CustomTextField
import com.example.rickandmortyapp.components.LazyColumnForCharactersPage
import com.example.rickandmortyapp.data.model.CharacterModel
import com.example.rickandmortyapp.data.viewmodels.CharacterViewModel
import com.example.rickandmortyapp.ui.theme.Color1
import com.google.gson.Gson
import kotlinx.coroutines.flow.collectLatest
import java.net.URLEncoder

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ViewModelConstructorInComposable")
@ExperimentalMaterial3Api
@Composable
fun CharactersPage(navController: NavHostController) {
    val vm: CharacterViewModel = viewModel()
    val listState = rememberLazyListState()
    var currentPage = remember { mutableStateOf(1) }
    var isLoading = remember { mutableStateOf(false) }
    var hasMoreData = remember { mutableStateOf(true) }
    val context = LocalContext.current
    LaunchedEffect(listState) {
        snapshotFlow {
            listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
        }.collectLatest { lastVisibleItemIndex ->
            val totalItemCount = listState.layoutInfo.totalItemsCount
            if (lastVisibleItemIndex == totalItemCount - 1) {
                // 🔁 Sayfanın sonuna gelindi: yeni verileri çek
                Log.i("CharactersPage", "sonuna gelindi")
            }
        }
    }

    // bunu çalıştırmaya gerek yoktur çünkü viewmodel
    // içinde zaten çalışan bir init fonksiyonu vardır.
    /*LaunchedEffect(true) {
        try {
            vm.loadCharacters();
        } catch (e: Exception) {
            Log.e("ErrorCharactersPage", e.message.toString())
        }
    }*/

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Rick And Morty") },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings", tint = Color1
                        )
                    }
                }
            )
        },
        content = {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(top = it.calculateTopPadding()),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                CustomTextField(vm.searchParameter, onValueChange = {
                    vm.clearCharacters()
                    vm.searchParameter.value = it
                    vm.searchCharacter(it, context)
                })

                LazyColumnForCharactersPage(Modifier.weight(1f), listState, vm.characterList, onCardPress = {
                    val characterJsonData = URLEncoder.encode(Gson().toJson(it), "UTF-8")
                    navController.navigate("characterDetail/$characterJsonData")
                })

            }
     }
    )
}




