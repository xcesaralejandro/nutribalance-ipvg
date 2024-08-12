package com.nutribalance.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nutribalance.components.FooterLayout
import com.nutribalance.components.HorizontalSpacer
import com.nutribalance.components.ListAccountActivity
import com.nutribalance.components.NavigationBar
import com.nutribalance.components.PageScrollableContainer
import com.nutribalance.components.SectionDivider
import com.nutribalance.components.SectionHeader
import com.nutribalance.navigation.AppScreens
import com.nutribalance.ui.theme.CalorieAccountTheme
import com.nutribalance.ui.theme.Typography
import com.nutribalance.ui.theme.positiveBalanceDark
import com.nutribalance.ui.theme.positiveBalanceLight
import com.nutribalance.viewModels.HomeViewModel
import androidx.compose.ui.res.stringResource
import com.nutribalance.R

@Composable
fun HomeScreen(navController: NavHostController){
    val viewModel = HomeViewModel()
    CalorieAccountTheme() {
        FooterLayout(
            content = { HomeContent(navController, viewModel) },
            footer = { NavigationBar(navController) }
        )
    }
}

@Composable
@Stable
fun HomeContent(navController : NavHostController, viewModel : HomeViewModel){
    PageScrollableContainer(
        content = {
            SectionHeader(
                title = stringResource(id = R.string.home_screen_title_balance),
                description = stringResource(id = R.string.home_screen_description_balance),
            )
            AccountState(viewModel)
            HorizontalSpacer()
            SectionDivider()
            SectionHeader(
                title = stringResource(id = R.string.home_screen_title_last_records),
                description = null,
            )
            ActivitySummary(navController, viewModel)
        },
        modifier = Modifier.padding(bottom = 20.dp)
    )
}
@Composable
fun ActivitySummary(navController: NavHostController, viewModel : HomeViewModel){
    val activityRecords = viewModel.getLastActivity(LocalContext.current)
    ListAccountActivity(
        activityRecords,
        listModifier = Modifier.height(
            if(activityRecords.size < 5) 200.dp else 300.dp
        )
    )
    if(activityRecords.isNotEmpty()){
        HorizontalSpacer()
        Text(
            text = stringResource(id = R.string.home_screen_button_see_all_records),
            style = Typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(MaterialTheme.colorScheme.background)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onBackground,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(10.dp)
                .clickable {
                    navController.navigate(AppScreens.ListRecordsScreen.route)
                }
        )
    }
}

@Composable
fun AccountState(viewModel: HomeViewModel){
    val totalKcal = viewModel.getTotal(LocalContext.current)
    var textColor = MaterialTheme.colorScheme.onSurfaceVariant
    if(totalKcal > 0){
        textColor = if (isSystemInDarkTheme()) positiveBalanceDark else positiveBalanceLight
    }
    Column(
        horizontalAlignment=Alignment.CenterHorizontally,
        verticalArrangement=Arrangement.Center,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant, shape = RoundedCornerShape(10.dp))
            .padding(20.dp)
    ){
        Row{
            Text(
                text = "$totalKcal",
                color = textColor,
                style = Typography.displayLarge,
                fontWeight = FontWeight.Black
            )
            Text(
                text = stringResource(id = R.string.general_label_kcal),
                color = textColor,
                style = Typography.titleLarge,
                modifier = Modifier.padding(start = 2.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreview(){
    val navController = rememberNavController()
    CalorieAccountTheme{
        HomeScreen(navController)
    }
}