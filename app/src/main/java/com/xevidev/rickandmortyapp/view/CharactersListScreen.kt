package com.xevidev.rickandmortyapp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
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
            .padding(vertical = 8.dp, horizontal = 32.dp)
    ) {
        Row {
            AsyncImage(
                model = character.image,
                contentDescription = null,
            )
            Column {
               DataCard(character = character)
            }
        }
    }
}

@Composable
fun DataCard(character: CharacterDomain){
    Text(text = character.name,
        modifier = Modifier.padding(8.dp),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp
    )
    Text(text = character.status+"-"+character.species,
        modifier = Modifier.padding(8.dp))
}

@Composable
fun TopBar(charactersViewModel: CharactersViewModel){
    TopAppBar(title = { /*TODO*/ })
}