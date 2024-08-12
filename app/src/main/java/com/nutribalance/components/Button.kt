package com.nutribalance.components

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nutribalance.ui.theme.CalorieAccountTheme
import com.nutribalance.ui.theme.Typography

@Composable
fun PrimaryButton(text :String, onClick: () -> Unit, modifier: Modifier = Modifier) {
        FilledTonalButton(
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            onClick = { onClick() },
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .then(modifier)
        ) {
        Text(
            text = text,
            style = Typography.bodyLarge,
        )
    }
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ButtonComponentsPreview(){
    CalorieAccountTheme {
        PageContainer(content = {
            PrimaryButton(text = "Hola", {})
        })
    }
}