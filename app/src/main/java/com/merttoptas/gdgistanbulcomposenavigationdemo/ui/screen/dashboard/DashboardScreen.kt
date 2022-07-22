package com.merttoptas.gdgistanbulcomposenavigationdemo.ui.screen.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.merttoptas.gdgistanbulcomposenavigationdemo.R
import com.merttoptas.gdgistanbulcomposenavigationdemo.ui.theme.BLUEMAGENTA
import com.merttoptas.gdgistanbulcomposenavigationdemo.ui.theme.LIGHTBLUEMAGENTA

@Composable
fun DashboardScreen(userName: String) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        content = { Content(userName) },
        backgroundColor = BLUEMAGENTA,
    )
}

@Composable
private fun Content(userName:String) {
    ConstraintLayout {
        val (image, header) = createRefs()
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
            Image(
                painterResource(R.drawable.gdg_istanbul_logo),
                contentDescription = "",
                modifier = Modifier.align(Alignment.Center),
            )
        }

        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 170.dp)
                .constrainAs(header) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(30.dp)
            ) {
                Text(
                    text = "Hi $userName!",
                    style = MaterialTheme.typography.h6
                )
                Text(
                    modifier = Modifier
                        .padding(top = 15.dp),
                    text = "Welcome to Dashboard",
                    style = MaterialTheme.typography.subtitle1
                )

                Text(
                    modifier = Modifier
                        .padding(top = 15.dp),
                    text = "You are logged in",
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}
