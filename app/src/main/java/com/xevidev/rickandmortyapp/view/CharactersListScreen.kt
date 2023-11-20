package com.xevidev.rickandmortyapp.view

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@RootNavGraph(start = true)
@Destination
fun CharactersListScreen(
    charactersViewModel: CharactersViewModel,
    navigator: DestinationsNavigator
){

}