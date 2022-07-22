package com.merttoptas.gdgistanbulcomposenavigationdemo.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.merttoptas.gdgistanbulcomposenavigationdemo.ui.theme.LIGHTGRAY

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.background,
    placeholder: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    shape: Shape = MaterialTheme.shapes.medium,
    border: BorderStroke = BorderStroke(1.dp, LIGHTGRAY)
) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = MaterialTheme.shapes.medium
            )
            .border(
                border = border,
                shape = shape
            )
            .fillMaxWidth()
            .height(50.dp),
        enabled = enabled,
        textStyle = MaterialTheme.typography.body2,
        isError = isError,
        placeholder = placeholder,
        trailingIcon = trailingIcon,
        leadingIcon = leadingIcon,
        visualTransformation = visualTransformation,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.textFieldColors(
            focusedLabelColor = MaterialTheme.colors.primary,
            backgroundColor = backgroundColor,
            cursorColor = MaterialTheme.colors.primary,
            textColor = MaterialTheme.colors.primary,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent

        ),
        singleLine = true,
        shape = shape
    )
}