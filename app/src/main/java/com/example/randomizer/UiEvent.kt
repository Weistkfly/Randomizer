package com.example.randomizer

sealed class UiEvent {
    data class Navigate(val route: String): UiEvent()
}
