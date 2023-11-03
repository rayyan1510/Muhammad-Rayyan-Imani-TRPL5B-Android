package com.example.trpl5bandroidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trpl5bandroidcourse.screen.Home
import com.example.trpl5bandroidcourse.screen.Output
import com.example.trpl5bandroidcourse.screen.Profile
import com.example.trpl5bandroidcourse.ui.theme.TRPL5BandroidCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TRPL5BandroidCourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    SplashScreen()
                }
            }
        }
    }
}

@Composable
fun SplashScreen() {
    /* varibale for navigate*/
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Home.route){

        /*daftarkan routes antar page : Home*/
        composable(Routes.Home.route){
            // landing page and melewati navControler
            Home(navController = navController)
        }

        /*daftarkan routes antar page : Profile*/
        composable(Routes.Profile.route){
            // landing page and melewati navControler
            Profile(navController = navController)
        }

        /*daftarkan routes antar page : Output dan kirimkan data number count pada home screen*/
        composable(Routes.Output.route + "/{id}"){ navBackStack ->

            /* Extracting the argument from home screen as like a count number */
            val counterNumb = navBackStack.arguments?.getString("id")

            // landing page and melewati navControler
            Output(value = counterNumb)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TRPL5BandroidCourseTheme {
        SplashScreen()
    }
}