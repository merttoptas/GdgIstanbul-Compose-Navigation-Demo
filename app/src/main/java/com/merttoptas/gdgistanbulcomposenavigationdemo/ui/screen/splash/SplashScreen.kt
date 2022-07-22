package com.merttoptas.gdgistanbulcomposenavigationdemo.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.merttoptas.gdgistanbulcomposenavigationdemo.R
import com.merttoptas.gdgistanbulcomposenavigationdemo.ui.theme.BLUEMAGENTA
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    directToLogin: () -> Unit
) {
    Body()
    LaunchedEffect(Unit) {
        launch {
            delay(2000)
            directToLogin.invoke()
        }
    }
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
            text = stringResource(id = R.string.app_name),
            color = BLUEMAGENTA,
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
