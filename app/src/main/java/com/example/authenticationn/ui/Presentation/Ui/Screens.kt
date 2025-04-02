package com.example.authenticationn.ui.Presentation.Ui

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

sealed class route(){

@Serializable
    data object signInScreen: route()
    @Serializable
    data object singUpScreen: route()
}


