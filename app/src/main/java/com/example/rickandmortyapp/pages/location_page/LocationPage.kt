package com.example.rickandmortyapp.pages.location_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.components.LocationCardWidget
import com.example.rickandmortyapp.ui.theme.Color1

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun LocationsPage() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Image(
            painter = painterResource(R.drawable.bg_image),
            contentDescription = "SVG ikon",
            modifier = Modifier
                .width(500.dp)
                .height(400.dp),

            )
        TopAppBar(
            title = {
                Text("Konum")
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
            )

        )


        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = TopAppBarDefaults.LargeAppBarExpandedHeight)
                .align(Alignment.BottomCenter)
                .border(
                    color = Color1,
                    width = 1.dp,
                    shape = RoundedCornerShape(topStart = 90.dp, topEnd = 90.dp)
                ), shape = RoundedCornerShape(topStart = 90.dp, topEnd = 90.dp)
        ) {
            LazyColumn (Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 50.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally){
                itemsIndexed(listOf<String>("", "")) { str, index ->
                    LocationCardWidget()
                }
            }
        }
    }

}