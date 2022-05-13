package com.example.randomizer.user_interface.home

sealed class HomeEvent {
    object OnFlipCoinClick: HomeEvent()
    object OnRollDiceClick: HomeEvent()
}
