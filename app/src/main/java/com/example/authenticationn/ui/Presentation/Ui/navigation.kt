package com.example.authenticationn.ui.Presentation.Ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.authenticationn.FireBaseViewModel

@Composable
fun navigation(){
 val viewModel = viewModel<FireBaseViewModel>()
    val navHostController = rememberNavController()

    NavHost(navController = navHostController,startDestination = route.signInScreen){
         composable<route.signInScreen> {
             loginScreen(navHostController,viewModel)
         }
        composable<route.singUpScreen>{
            signUpScreen(navHostController,viewModel)
        }

    }
}