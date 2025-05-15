package com.example.rickandmortyapp.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapp.ui.theme.CharacterPropertyCardColor

@Composable
 fun CharacterPropertyCard(textString: String) {
    ElevatedCard(modifier = Modifier.padding(horizontal = 3.dp, vertical = 3.dp), colors = CardDefaults.elevatedCardColors(
            containerColor = CharacterPropertyCardColor
        ), shape  = RoundedCornerShape(45.dp)) { Text(textString, Modifier.padding(10.dp)) }
}
