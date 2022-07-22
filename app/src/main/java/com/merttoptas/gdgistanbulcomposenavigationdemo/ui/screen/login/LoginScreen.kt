package com.merttoptas.gdgistanbulcomposenavigationdemo.ui.screen.login

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
fun LoginScreen(
    navigateToDashBoard: (String) -> Unit,
    navigateToRegister: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    var userName by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        content = {
            Body(
                navigateToRegister = {
                    navigateToRegister.invoke()

                },
                navigateToDashBoard = {
                    navigateToDashBoard.invoke(it)
                },
                userName = userName,

                onUserNameChange = {
                    userName = it
                }
            )
        },
    )
}

@Composable
private fun Body(
    navigateToRegister: () -> Unit,
    navigateToDashBoard: (String) -> Unit,
    onUserNameChange: (String) -> Unit,
    userName: String?,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Image(
            painterResource(com.merttoptas.gdgistanbulcomposenavigationdemo.R.drawable.ic_login_images),
            contentDescription = "",
            modifier = Modifier
                .height(250.dp)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        )

        UserNameInput(userName = userName,onUserNameChange)
        PasswordInput()
        LoginButton(navigateToDashBoard, userName)
        Text( "Or",
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 10.dp),
        )
        RegisterButton(navigateToRegister)
    }
}

@Composable
private fun UserNameInput(userName:String?, onChangeValue: (String) -> Unit) {

    CustomTextField(
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 10.dp),
        value = userName ?: "",
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
                contentDescription = "")
        },
        onValueChange = {
            onChangeValue.invoke(it)
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
private fun LoginButton(navigateToDashBoard: (String) -> Unit, userName:String?) {
    Button(
        onClick = {
            navigateToDashBoard.invoke("$userName")
        },
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, top = 16.dp),
        colors =  ButtonDefaults.buttonColors(backgroundColor =BLUEMAGENTA),
        shape = RoundedCornerShape(8.dp),
        content = {
            Text(
                text = "Login",
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