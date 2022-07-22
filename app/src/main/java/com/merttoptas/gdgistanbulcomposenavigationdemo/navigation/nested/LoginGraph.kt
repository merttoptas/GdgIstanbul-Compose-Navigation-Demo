package com.merttoptas.gdgistanbulcomposenavigationdemo.navigation.nested

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.merttoptas.gdgistanbulcomposenavigationdemo.navigation.NavScreen
import com.merttoptas.gdgistanbulcomposenavigationdemo.ui.screen.login.LoginScreen
import com.merttoptas.gdgistanbulcomposenavigationdemo.ui.screen.register.RegisterScreen

/**
 * Created by merttoptas on 23.06.2022
 */

@ExperimentalComposeUiApi
fun NavGraphBuilder.loginGraph(navController: NavController) {
    navigation(startDestination = NavScreen.Login.route, route = "loginGraph") {
        composable(route = NavScreen.Login.route) {
             LoginScreen(
                navigateToDashBoard = {
                    navController.navigate(NavScreen.Dashboard.route.plus("?userName=${it}")) {
                        popUpTo(0)
                    }
                },
                 navigateToRegister = {
                     navController.navigate(NavScreen.Register.route)
                 })
        }
        composable(route = NavScreen.Register.route) {
             RegisterScreen(
                 navigateToBackLogin = {
                     navController.popBackStack()
                 },
                navigateToDashBoard = {
                    navController.navigate(NavScreen.Dashboard.route) {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}