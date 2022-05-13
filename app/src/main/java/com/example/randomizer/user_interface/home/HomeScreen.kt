package com.example.randomizer.user_interface.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.randomizer.UiEvent


@Composable
fun HomeScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    //Why should this be here?
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
            }
        }
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text(
            text = "Randomizer",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(20.dp))
        OutlinedButton(
            onClick = {
                viewModel.onEvent(HomeEvent.OnFlipCoinClick)
        })
        {
            Text(text = "Flip a coin")
        }
        OutlinedButton(
            onClick = {
                viewModel.onEvent(HomeEvent.OnRollDiceClick)
            })
        {
            Text(text = "Roll a dice")
        }
    }
}