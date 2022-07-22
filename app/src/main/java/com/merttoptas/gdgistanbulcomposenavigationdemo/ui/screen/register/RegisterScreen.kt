package com.merttoptas.gdgistanbulcomposenavigationdemo.ui.screen.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.merttoptas.gdgistanbulcomposenavigationdemo.component.CustomTextField
import com.merttoptas.gdgistanbulcomposenavigationdemo.ui.theme.BLUEMAGENTA

@ExperimentalComposeUiApi
@Composable
fun RegisterScreen(
    navigateToDashBoard: () -> Unit,
    navigateToBackLogin: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        content = {
            Body(
                navigateToBackLogin = {
                    navigateToBackLogin.invoke()

                },
                navigateToDashBoard = {
                    navigateToDashBoard.invoke()
                }
            )
        },
    )
}

@Composable
private fun Body(
    navigateToBackLogin: () -> Unit,
    navigateToDashBoard: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Image(
            painterResource(com.merttoptas.gdgistanbulcomposenavigationdemo.R.drawable.ic_register),
            contentDescription = "",
            modifier = Modifier
                .height(250.dp)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        )

        UserNameInput()
        PasswordInput()
        RegisterButton(navigateToDashBoard)
        Text( "Or",
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 10.dp),
        )

        LoginButton(navigateToBackLogin)
    }
}

@Composable
private fun UserNameInput(){
    var userName by remember { mutableStateOf("") }

    CustomTextField(
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 10.dp),
        value = userName,
        placeholder = {
            Text(
                color = Color.Gray,
                text = "Name",
                style = MaterialTheme.typography.body2
            )
        },
        leadingIcon = {
            Icon(
                Icons.Default.Person,
                contentDescription = "",

                )
        },
        onValueChange = {
            userName = it
        },
    )
}

@Composable
private fun PasswordInput(){
    var password by remember { mutableStateOf("") }

    CustomTextField(
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 10.dp),
        value = password,
        placeholder = {
            Text(
                color = Color.Gray,
                text = "Password",
                style = MaterialTheme.typography.body2
            )
        },
        leadingIcon = {
            Icon(
                Icons.Default.Lock,
                contentDescription = "",

                )
        },
        onValueChange = {
            password = it
        },
        visualTransformation =  PasswordVisualTransformation(),

        )
}

@Composable
private fun LoginButton(navigateToBackLogin: () -> Unit) {
    Button(
        onClick = navigateToBackLogin,
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, top = 16.dp),
        colors =  ButtonDefaults.buttonColors(backgroundColor =BLUEMAGENTA),
        shape = RoundedCornerShape(8.dp),
        content = {
            Text(
                text = "Back To Login",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
        }
    )
}

@Composable
private fun RegisterButton(navigateToRegister: () -> Unit) {
    Button(
        onClick = navigateToRegister,
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, top = 8.dp),
        colors =  ButtonDefaults.buttonColors(backgroundColor =BLUEMAGENTA),
        shape = RoundedCornerShape(8.dp),
        content = {
            Text(
                text = "Register",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
        }
    )
}