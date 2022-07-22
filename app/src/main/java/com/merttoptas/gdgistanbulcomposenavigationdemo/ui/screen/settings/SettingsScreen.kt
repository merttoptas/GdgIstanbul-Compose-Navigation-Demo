package com.merttoptas.gdgistanbulcomposenavigationdemo.ui.screen.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.merttoptas.gdgistanbulcomposenavigationdemo.R
import com.merttoptas.gdgistanbulcomposenavigationdemo.ui.theme.BLUEMAGENTA

@Composable
fun SettingsScreen() {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        content = { Body() },
        backgroundColor = Color.White,
        topBar = {
            TopAppBar(
                title = { Text(text = "Settings", color = Color.White) },
                backgroundColor = BLUEMAGENTA,
                elevation = 5.dp
            )
        }
    )
}

@Composable
private fun Body() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {

        Text(
            modifier = Modifier,
            text = "Settings Page",
            fontSize = 18.sp
        )
        Image(
            painterResource(R.drawable.gdg_istanbul_logo),
            contentDescription = "",
            modifier = Modifier,
        )
    }
}

@Preview
@Composable
fun BodyPreview() {
    Body()
}
