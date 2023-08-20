package com.jrektabasa.superhero.util.navigation

sealed class NavigationScreen(val route: String) {
    object DashBoard : NavigationScreen("dashboard")
    object Hero : NavigationScreen("hero/{id}")
    //add more screen here...
}
