package com.example.mytestapp.common

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    value: String,
    label: String,
    placeholder: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: (@Composable () -> Unit)? = null,
//    tailingIcon: (@Composable()->Unit)? = null,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
        onValueChange = onValueChange,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        leadingIcon = leadingIcon,
    )
}