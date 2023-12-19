package com.xevidev.rickandmortyapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.xevidev.rickandmortyapp.domain.model.CharacterDomain

@Destination
@Composable
fun SingleCharacterScreen(
    navigator: DestinationsNavigator,
    character: CharacterDomain
) {
    Column(Modifier.fillMaxSize()) {
        TopBar(navigator = navigator)
        ContentCharacter(character)
    }
}

@Composable
fun ContentCharacter(character: CharacterDomain) {
    Column {
        Box(
            Modifier
                .fillMaxWidth()
                .padding(8.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            CharacterImage(character.image)
        }
        Box(
            Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(32.dp, 32.dp, 0.dp, 0.dp)),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.Yellow)
            ) {
                CharacterInfo(character)
            }
        }

    }
}

@Composable
fun CharacterInfo(character: CharacterDomain) {
    Text(text = character.name)
    Text(text = character.status)
    Text(text = character.species)
    Text(text = character.location.name)
    Text(text = character.origin.name)
    IconButton(onClick = { /*TODO*/ }, ) {
        Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
    }
} 

@Composable
fun CharacterImage(image: String) {
    AsyncImage(
        model = image,
        contentDescription = "character img",
        modifier = Modifier.fillMaxWidth()
    ) 
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navigator: DestinationsNavigator) {
    CenterAlignedTopAppBar(title = { Text(text = "BeerApp") },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { navigator.popBackStack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    tint = Color.White,
                    contentDescription = ""
                )
            }
        })
}