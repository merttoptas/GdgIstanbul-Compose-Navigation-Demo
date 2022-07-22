package com.merttoptas.gdgistanbulcomposenavigationdemo.navigation

import com.merttoptas.gdgistanbulcomposenavigationdemo.R

enum class BottomNav(
    val route: String,
    val IconId: Int,
    val screenName: String
) {
    DASHBOARD(NavScreen.Dashboard.route.plus("?userName={userName}"), R.drawable.ic_baseline_home_24, "Dashboard"),
    SETTINGS(
        NavScreen.Settings.route.plus("?name={name}"),
        R.drawable.ic_baseline_settings_24,
       "Settings"
    ),

}