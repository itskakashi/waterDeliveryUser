package com.example.authenticationn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.authenticationn.ui.Presentation.Ui.navigation
import com.example.authenticationn.ui.theme.AuthenticationnTheme
import com.example.authenticationn.ui.Presentation.Ui.signUpScreen
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {
    private val viewModel: FireBaseViewModel by viewModels()
    private val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AuthenticationnTheme {
                navigation()
            }
        }
    }
}