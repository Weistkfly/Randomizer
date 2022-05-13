package com.example.randomizer.user_interface.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomizer.UiEvent
import com.example.randomizer.util.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

): ViewModel() {
    private val _uiEvent =  Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: HomeEvent){
        when(event){
            is HomeEvent.OnFlipCoinClick -> {
                sendUiEvent((UiEvent.Navigate(Routes.FLIP_COIN)))
            }
            is HomeEvent.OnRollDiceClick -> {
                sendUiEvent((UiEvent.Navigate(Routes.ROLL_DICE)))
            }
        }

    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}

