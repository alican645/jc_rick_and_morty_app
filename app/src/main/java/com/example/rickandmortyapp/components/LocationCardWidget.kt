package com.example.rickandmortyapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LocationCardWidget() {
    Card(Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 2.dp)) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                Icons.Default.LocationOn, "", Modifier.size(48.dp)
            )
            Column {
                Text("C-127", modifier = Modifier.padding(), fontSize = 18.sp)
                Spacer(Modifier.size(10.dp))
                Text("Tür: Planet", modifier = Modifier.padding())
                Text("Kişi Sayısı: 27", modifier = Modifier.padding())
            }
            Spacer(Modifier.weight(1f))
            Icon(
                Icons.Default.KeyboardArrowRight, "", Modifier.size(48.dp)
            )
        }
    }
}