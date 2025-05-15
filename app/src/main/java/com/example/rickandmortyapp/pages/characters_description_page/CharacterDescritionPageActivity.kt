package com.example.rickandmortyapp.pages.characters_description_page

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.components.CharacterPropertyCard
import com.example.rickandmortyapp.components.EpisodeCardWidget
import com.example.rickandmortyapp.components.LocationCardWidget
import com.example.rickandmortyapp.data.model.CharacterModel
import com.example.rickandmortyapp.ui.theme.CharacterPropertyCardColor
import com.example.rickandmortyapp.ui.theme.Color1
import com.example.rickandmortyapp.ui.theme.RickAndMortyAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(navController: NavController,characterModel: CharacterModel) {
    Scaffold(
        content = {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                Image(
                    painter = painterResource(R.drawable.bg_image),
                    contentDescription = "SVG ikon",
                    modifier = Modifier
                        .width(500.dp)
                        .height(400.dp)
                )
                TopAppBar(
                    title = {
                        Text("Karakter")
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack()}) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },
                    actions = {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "",
                            tint = Color1
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    ),


                )
                Image(
                    painter = rememberAsyncImagePainter(model = characterModel.image),
                    contentDescription = "Character",
                    modifier = Modifier
                        .align(alignment = Alignment.TopCenter)
                        .padding(top = 100.dp)
                        .width(125.dp)
                        .height(125.dp).clip(RoundedCornerShape(20.dp))
                        .border(width = 1.dp, color = Color1, shape = RoundedCornerShape(20.dp))
                )

                Surface(
                    modifier = Modifier
                        .fillMaxWidth() .padding(top = 250.dp)
                        .align(Alignment.BottomCenter)
                        .border(
                            color = Color1,
                            width = 1.dp,
                            shape = RoundedCornerShape(topStart = 90.dp, topEnd = 90.dp)
                        ), shape = RoundedCornerShape(topStart = 90.dp, topEnd = 90.dp)
                ) {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(10.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(characterModel.name, fontSize = 25.sp)
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CharacterPropertyCard(textString = characterModel.status)
                            CharacterPropertyCard(textString = characterModel.origin.name)
                        }
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CharacterPropertyCard(textString = characterModel.species)
                            CharacterPropertyCard(textString = characterModel.gender)
                        }
                        Text(
                            "Bölümler", modifier = Modifier
                                .padding(top = 10.dp)
                                .align(Alignment.Start), fontSize = 18.sp
                        )
                        LazyColumn {
                            itemsIndexed(characterModel.episode) { index, item ->
                                EpisodeCardWidget(item.toString(),item.toString())
                            }
                        }
                    }
                }
            }


        },


        )
}







