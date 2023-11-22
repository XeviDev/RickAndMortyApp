package com.xevidev.rickandmortyapp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.xevidev.rickandmortyapp.domain.model.CharacterDomain

@Composable
@RootNavGraph(start = true)
@Destination
fun CharactersListScreen(
    charactersViewModel: CharactersViewModel,
    navigator: DestinationsNavigator
) {
    charactersViewModel.getCharacters()
    val characters by charactersViewModel.characters.collectAsState()

    LazyColumn {

        items(characters) { character ->
            CharacterCard(character = character)
        }
    }
}

@Composable
fun CharacterCard(character: CharacterDomain) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row {
            AsyncImage(
                model = "https://example.com/image.jpg",
                contentDescription = null,
            )
            Column {
                Text(text = character.name, modifier = Modifier.padding(8.dp))
                Text(text = character.species, modifier = Modifier.padding(8.dp))
                Text(text = character.status, modifier = Modifier.padding(8.dp))
            }
        }
    }
}