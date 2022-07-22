package com.merttoptas.gdgistanbulcomposenavigationdemo.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.*
import com.merttoptas.gdgistanbulcomposenavigationdemo.component.CustomBottomAppBar
import com.merttoptas.gdgistanbulcomposenavigationdemo.navigation.nested.loginGraph
import com.merttoptas.gdgistanbulcomposenavigationdemo.ui.screen.dashboard.DashboardScreen
import com.merttoptas.gdgistanbulcomposenavigationdemo.ui.screen.settings.SettingsScreen
import com.merttoptas.gdgistanbulcomposenavigationdemo.ui.screen.splash.SplashScreen

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NavGraph(startDestination: String = NavScreen.Splash.route, navController : NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val uri = "gdg://settings"

    Scaffold(
        bottomBar = {
            BottomNav.values().forEach { navItem ->
                if (navItem.route == currentRoute) {
                    CustomBottomAppBar(
                        navController = navController,
                        currentRoute = currentRoute
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startDestination,
            Modifier.padding(innerPadding)
        ) {
            composable(NavScreen.Splash.route) {
                SplashScreen(
                    directToLogin = {
                        navController.navigate(NavScreen.Login.route) {
                            popUpTo(0)
                        }
                    },
                )
            }
            composable(NavScreen.Settings.route.plus("?name={name}"),
                deepLinks = listOf(navDeepLink { uriPattern = "$uri/{name}"}) ) { backStackEntry->
                SettingsScreen(backStackEntry.arguments?.getString("name") ?: "",)
            }

            composable(NavScreen.Dashboard.route.plus("?userName={userName}"), arguments = listOf(navArgument("userName") { defaultValue = "" })) { backStackEntry ->
                DashboardScreen(
                    backStackEntry.arguments?.getString("userName") ?: "",
                )
            }

            /*
            Second way

             composable(NavScreen.Dashboard.route.plus("?userName={userName}"), arguments = listOf(navArgument("userName") { defaultValue = "" })) { backStackEntry ->
              backStackEntry.savedStateHandle.get<String>(NavScreen.Dashboard.userName)?.let {
                   NavBackStackEntry.savedStateHandle.set(
                            NavScreen.Dashboard.userName,
                            ""
                        )
                }
                DashboardScreen(
                    navigateToLogin = {
                        navController.navigate(NavScreen.Login.route) {
                            popUpTo(0)
                        }
                    }
                )
            }
             */
            loginGraph(navController)
        }
    }
}