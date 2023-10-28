package com.example.trpl5bandroidcourse

sealed class Routes (val route: String) {

    object  Home : Routes("home")

    object  Profile : Routes("profile")

    object  Output : Routes("output")

}