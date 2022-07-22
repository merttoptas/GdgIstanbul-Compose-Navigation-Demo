package com.merttoptas.gdgistanbulcomposenavigationdemo.navigation

sealed class NavScreen(val route: String) {
    object Splash : NavScreen("splash")
    object Dashboard : NavScreen("dashboard")
    //Second Way
    /*
        object Dashboard : NavScreen("dashboard") {
             const val userName = "USER_NAME_DATA"
        }
     */


    object Login : NavScreen("login")
    object Register : NavScreen("register")
    object Settings : NavScreen("settings")

}