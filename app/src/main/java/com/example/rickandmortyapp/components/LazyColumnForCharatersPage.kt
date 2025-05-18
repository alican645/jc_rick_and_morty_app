package com.example.rickandmortyapp.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapp.data.model.CharacterModel

@Composable
fun LazyColumnForCharactersPage(modifier: Modifier = Modifier, listState: LazyListState, characters: List<CharacterModel?>, onCardPress:(CharacterModel)-> Unit) {
    LazyColumn(Modifier
        .padding(vertical = 10.dp), state = listState) {
        itemsIndexed(characters) { index, model ->

            model?.let { characterModel ->
                CharacterCard(onClick = onCardPress, characterModel = characterModel)
            }
        }
    }
}
