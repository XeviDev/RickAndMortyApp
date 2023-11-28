package com.xevidev.rickandmortyapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    CharacterImage(character.image)
    CharacterInfo(character)
}

@Composable
fun CharacterInfo(character: CharacterDomain) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
    )
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