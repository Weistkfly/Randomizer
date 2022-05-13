package com.example.randomizer.user_interface.roll_dice

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomizer.R
import com.example.randomizer.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RollDiceViewModel@Inject constructor(

): ViewModel() {

    var diceNumber by mutableStateOf(1)
        private set

    var diceImage by mutableStateOf(R.drawable.alea_1)
        private set

    fun onEvent(event: RollDiceEvent){
        when(event){
            is RollDiceEvent.RollDice -> {
                diceNumber = (1..6).random()
                when(diceNumber){
                    1 -> diceImage = R.drawable.alea_1
                    2 -> diceImage = R.drawable.alea_2
                    3 -> diceImage = R.drawable.alea_3
                    4 -> diceImage = R.drawable.alea_4
                    5 -> diceImage = R.drawable.alea_5
                    6 -> diceImage = R.drawable.alea_6
                }
            }
        }
    }
}