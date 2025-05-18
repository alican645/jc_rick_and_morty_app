package com.example.rickandmortyapp.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.rickandmortyapp.data.model.CharacterModel
import com.example.rickandmortyapp.ui.theme.CardBgColor
import com.example.rickandmortyapp.ui.theme.Color1


@Composable
 fun CharacterCard(onClick: (CharacterModel) -> Unit, characterModel: CharacterModel) {
    Card(
        modifier = Modifier
            .padding(end = 10.dp, start = 10.dp, top = 10.dp)
            .width(400.dp),

        colors = CardDefaults.cardColors(
            containerColor = CardBgColor
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.clickable(onClick = { onClick(characterModel) })
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = characterModel.image),
                contentDescription = "SVG ikon",
                modifier = Modifier.size(100.dp)
            )
            Column(
                modifier = Modifier.padding(start = 10.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    text = characterModel.name, style = TextStyle(fontSize = 14.sp)
                )
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    text = "Köken",
                    style = TextStyle(fontSize = 10.sp)
                )
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    text = characterModel.location.name,
                    style = TextStyle(fontSize = 12.sp)
                )
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    text = "Durum",
                    style = TextStyle(fontSize = 10.sp)
                )
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    text = characterModel.status,
                    style = TextStyle(fontSize = 12.sp)
                )
            }
            Spacer(Modifier.weight(1f))


            Icon(
                modifier = Modifier.align(Alignment.Top),
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "", tint = Color1

            )


        }
    }
}

