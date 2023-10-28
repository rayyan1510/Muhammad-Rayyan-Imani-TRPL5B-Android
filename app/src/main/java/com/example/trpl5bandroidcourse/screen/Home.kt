package com.example.trpl5bandroidcourse.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.trpl5bandroidcourse.Routes

@Composable
fun Home(navController: NavHostController){

    var numbercount by remember {
        mutableStateOf(0)
    }

    /*A Box as a container and the position at center*/
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Column (modifier = Modifier.align(Alignment.Center)){
            Text("Selamat datang, the value is $numbercount", color = Color.Black, fontWeight = FontWeight.Medium)
            
            Row (modifier = Modifier.padding( vertical = 10.dp)){
                /* a button for increment */
                Button(onClick = { numbercount++ }) {
                    Text(text = "+", color = Color(0xFFFCF5ED))
                }

                /* a button for increment */
                Button(onClick = { numbercount-- }, modifier = Modifier.padding(horizontal = 20.dp)) {
                    Text(text = "-", color = Color(0xFFFCF5ED))
                }
            }

            /* a button for decrement*/

            /* a btn for navigation Profile */
            Button(onClick = { navController.navigate(Routes.Profile.route) }) {
                Text(text = "go to Profile", color = Color(0xFFFCF5ED)) //navigate to profile
            }


            /* a btn for navigation Output */
            Button(onClick = { navController.navigate(Routes.Output.route + "/$numbercount") }) {
                /**
                 * User navController to navigate to Output Screen
                 * [Routes.Output.route] is a string which describes route we created in [Routes] class.
                 * Pass counter as argument by adding to the end. The final route will become
                 * (lets say counter value is 8) "../Output/8"
                 */

                Text(text = "go to Output pages", color = Color(0xFFFCF5ED)) //navigate to profile
            }
        }
    }
}