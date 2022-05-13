package com.example.randomizer.user_interface.flip_coin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.randomizer.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FlipCoinViewModel@Inject constructor(

): ViewModel() {

    var coinSide by mutableStateOf(1)
        private set

    var coinSideImage by mutableStateOf(R.drawable.face)
        private set

    fun onEvent(event: FlipCoinEvent){
        when(event){
            is FlipCoinEvent.FlipCoin -> {
                coinSide = (1..2).random()
                coinSideImage = if (coinSide == 1) R.drawable.face else R.drawable.cross
            }
        }
    }
}