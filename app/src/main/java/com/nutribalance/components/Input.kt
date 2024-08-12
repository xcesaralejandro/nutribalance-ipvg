package com.nutribalance.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nutribalance.ui.theme.CalorieAccountTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.nutribalance.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlineNumberInput(
    label: String,
    text: String,
    modifier: Modifier = Modifier,
    onTextChange: (String) -> Unit,
    ) {
    OutlinedTextField(
        value = text,
        onValueChange = { newText ->
            if (newText.all { it.isDigit() }) {
                onTextChange(newText)
            }
        },
        singleLine = true,
        label = { Text(label) },
        textStyle = Typography.bodyLarge,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .then(modifier),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            containerColor = MaterialTheme.colorScheme.background,
            cursorColor = MaterialTheme.colorScheme.onBackground,
            focusedLabelColor = MaterialTheme.colorScheme.onBackground,
            unfocusedLabelColor = MaterialTheme.colorScheme.onBackground
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlineTextInput(
    label: String,
    text : String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = text,
        onValueChange = { newText -> onTextChange(newText) },
        singleLine = true,
        label = { Text(label) },
        textStyle = Typography.bodyLarge,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .then(modifier),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            containerColor = MaterialTheme.colorScheme.background,
            cursorColor = MaterialTheme.colorScheme.onBackground,
            focusedLabelColor = MaterialTheme.colorScheme.onBackground,
            unfocusedLabelColor = MaterialTheme.colorScheme.onBackground
        )
    )
}


@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun InputComponentsPreview(){
    CalorieAccountTheme {
        Column{
            OutlineNumberInput(label = "OutlineNumberInput", text = "", onTextChange = {})
            OutlineTextInput(label = "OutlineTextInput", text = "", onTextChange = {})
        }
    }
}