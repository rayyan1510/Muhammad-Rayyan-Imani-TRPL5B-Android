package com.example.trpl5bandroidcourse.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.trpl5bandroidcourse.Routes

@Composable
fun Profile(navController: NavHostController){

    /*A Box as a container and the position at center*/
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Column (modifier = Modifier.align(Alignment.Center)){
            Text("Welcome, Now yout at Profile pages", color = Color.Black)

        }
    }
}