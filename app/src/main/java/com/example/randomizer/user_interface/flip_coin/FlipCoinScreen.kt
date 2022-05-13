package com.example.randomizer.user_interface.flip_coin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
@Composable
fun FlipCoinScreen(
    viewModel: FlipCoinViewModel = hiltViewModel()
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = viewModel.coinSideImage),
            contentDescription = "Coin Image",
            modifier = Modifier.size(125.dp)
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Button(onClick = {
            viewModel.onEvent(FlipCoinEvent.FlipCoin)
        }
        ) {
            Text(text = "Flip coin")
        }
    }
}