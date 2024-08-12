package com.nutribalance.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nutribalance.components.FooterLayout
import com.nutribalance.components.NavigationBar
import com.nutribalance.components.OutlineNumberInput
import com.nutribalance.components.OutlineTextInput
import com.nutribalance.components.PageScrollableContainer
import com.nutribalance.components.SectionHeader
import com.nutribalance.ui.theme.CalorieAccountTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.nutribalance.R
import com.nutribalance.components.HorizontalSpacer
import com.nutribalance.components.PrimaryButton
import com.nutribalance.components.SectionSubTitle
import com.nutribalance.models.Activity
import com.nutribalance.ui.theme.Typography
import com.nutribalance.viewModels.RecordCalorieViewModel

@Composable
fun RecordCaloriesScreen(navController: NavHostController){
    CalorieAccountTheme {
        FooterLayout(
            content = { RecordCaloriesContent() },
            footer = { NavigationBar(navController) }
        )
    }
}

@Composable
fun RecordCaloriesContent(){
    val viewModel = RecordCalorieViewModel()
    val context = LocalContext.current
    PageScrollableContainer(
        content = {
            SectionHeader(
                title = stringResource(id = R.string.record_calories_screen_title),
                description = stringResource(id = R.string.record_calories_screen_description))
            SectionSubTitle(text = stringResource(id = R.string.record_calories_screen_subtitle_about_record))
            TabbedComponent(viewModel)
            HorizontalSpacer()
            SectionSubTitle(text = stringResource(id = R.string.record_calories_screen_subtitle_record_description))
            OutlineNumberInput(
                label = viewModel.getLabelForCalorieValue(LocalContext.current),
                text = viewModel.kcal,
                onTextChange = {
                    viewModel.kcal = it
                }
            )
            OutlineTextInput(
                label = viewModel.getLabelForActionDescription(LocalContext.current),
                text = viewModel.description,
                onTextChange = {
                    viewModel.description = it
                })
            Spacer(modifier = Modifier.height(20.dp))
            PrimaryButton(
                text = stringResource(id = R.string.general_button_store),
                onClick = {
                    viewModel.storeActivity(context)
                })
        },
        modifier = Modifier.padding(bottom = 20.dp)
    )
}

@Composable
fun TabbedComponent(viewModel: RecordCalorieViewModel) {
    val selected = remember { mutableStateOf(Activity.TYPE_CALORIE_INTAKE) }
    val selectedText = MaterialTheme.colorScheme.onSecondaryContainer
    val unselectedText = MaterialTheme.colorScheme.onBackground
    val selectedBackground = MaterialTheme.colorScheme.secondaryContainer
    val unselectedBackground = MaterialTheme.colorScheme.background
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = stringResource(id = R.string.record_calories_screen_label_record_type_intake),
            style = Typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = if (selected.value == Activity.TYPE_CALORIE_INTAKE)  selectedText else unselectedText,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .wrapContentHeight()
                .background(if (selected.value == Activity.TYPE_CALORIE_INTAKE) selectedBackground else unselectedBackground)
                .border(
                    width = 2.dp,
                    color = if (selected.value == Activity.TYPE_CALORIE_INTAKE) selectedText else unselectedText,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(15.dp)
                .clickable {
                    selected.value = Activity.TYPE_CALORIE_INTAKE
                    viewModel.type = Activity.TYPE_CALORIE_INTAKE
                }
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = stringResource(id = R.string.record_calories_screen_label_record_type_performing_exercise),
            style = Typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = if (selected.value == Activity.TYPE_PERFORMING_EXERCISE)  selectedText else unselectedText,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .wrapContentHeight()
                .background(if (selected.value == Activity.TYPE_PERFORMING_EXERCISE) selectedBackground else unselectedBackground)
                .border(
                    width = 2.dp,
                    color = if (selected.value == Activity.TYPE_PERFORMING_EXERCISE) selectedText else unselectedText,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(15.dp)
                .clickable {
                    selected.value = Activity.TYPE_PERFORMING_EXERCISE
                    viewModel.type = Activity.TYPE_PERFORMING_EXERCISE
                }
        )
    }
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun RecordCaloriesScreenPreview(){
    val navController = rememberNavController()
    CalorieAccountTheme{
        RecordCaloriesScreen(navController)
    }
}