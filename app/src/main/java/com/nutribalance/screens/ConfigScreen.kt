package com.nutribalance.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nutribalance.components.FooterLayout
import com.nutribalance.components.PageContainer
import com.nutribalance.components.SectionHeader
import com.nutribalance.ui.theme.CalorieAccountTheme
import androidx.compose.ui.Alignment
import com.nutribalance.components.NavigationBar
@Composable
fun ConfigScreen(navController: NavHostController){
    CalorieAccountTheme() {
        FooterLayout(
            content = { ConfigContent() },
            footer = { ConfigFooter(navController) }
        )
    }
}
@Composable
fun ConfigContent(){
    PageContainer(
        content = {
            SectionHeader(
                title = "Configuración",
                description = null,
            )
            ThemeSection()
        }
    )
}

@Composable
fun ThemeSection(){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(text = "Seleccione el tema:", modifier = Modifier.align(Alignment.CenterVertically))
        Switch(
            checked = false,
            onCheckedChange = {

            }
        )
    }
}

@Composable
fun ConfigFooter(navController: NavHostController){
    NavigationBar(navController)
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ConfigScreenPreview(){
    val navController = rememberNavController()
    ConfigScreen(navController)
}