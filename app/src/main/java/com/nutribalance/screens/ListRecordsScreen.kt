package com.nutribalance.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.nutribalance.R
import com.nutribalance.components.ListAccountActivity
import com.nutribalance.components.NavigationBar
import com.nutribalance.repositories.ActivityRepository

@Composable
fun ListRecordsScreen(navController: NavHostController){
    CalorieAccountTheme {
        FooterLayout(
            content = {
                PageContainer(
                  content = {
                      SectionHeader(title = stringResource(id = R.string.list_records_screen_title), description = null)
                      ListRecordsContent()
                  }
                ) },
            footer = { ListRecordsFooter(navController) }
        )
    }
}
@Composable
fun ListRecordsContent(){
    val activityRepository = ActivityRepository(LocalContext.current)
    val activityData = activityRepository.all()
    if(activityData.isEmpty()){
        Text(color = MaterialTheme.colorScheme.onBackground,
            text = stringResource(id = R.string.list_records_screen_label_empty_records))
    }else{
        ListAccountActivity(activityData = activityData,
            listModifier = Modifier
                .fillMaxSize()
        )
    }
}

@Composable
fun ListRecordsFooter(navController: NavHostController){
    NavigationBar(navController)
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ListRecordsScreenPreview(){
    val navController = rememberNavController()
    ListRecordsScreen(navController)
}