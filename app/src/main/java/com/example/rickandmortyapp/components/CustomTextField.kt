package com.example.rickandmortyapp.components

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapp.ui.theme.BorderColor
import com.example.rickandmortyapp.ui.theme.Color1

@Composable

fun CustomTextField(searchParameter: MutableState<String>,onPress: ()-> Unit) {
    TextField(
        modifier = Modifier
            .padding(end = 10.dp, start = 10.dp)
            .width(400.dp)
            .border(width = 1.dp, color = BorderColor, shape = RoundedCornerShape(6.dp)),
        value = searchParameter.value,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White
        ),
        label = {
            Text("Karakterlerde Ara")
        },
        onValueChange = {
            searchParameter.value = it
        },
        leadingIcon = {

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search", tint = Color1
            )

        },
        trailingIcon = {
            IconButton(onClick = onPress) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More",
                    tint = Color1
                )
            }
        },
        shape = TextFieldDefaults.shape


    )
}
