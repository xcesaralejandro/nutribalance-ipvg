package com.nutribalance.components

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nutribalance.R
import com.nutribalance.models.Activity
import com.nutribalance.ui.theme.CalorieAccountTheme
import com.nutribalance.ui.theme.positiveBalanceDark
import com.nutribalance.ui.theme.positiveBalanceLight
import com.nutribalance.ui.theme.Typography
import com.nutribalance.util.DateParse
import java.util.Date
import java.util.UUID
import androidx.compose.foundation.combinedClickable

@SuppressLint("ModifierParameter")
@Composable
fun ListAccountActivity(
    activityData : MutableList<Activity> = mutableListOf(),
    listModifier: Modifier = Modifier,
    emptyModifier : Modifier = Modifier
){
    if(activityData.isEmpty()){
        Text(
            color = MaterialTheme.colorScheme.onBackground,
            text = stringResource(id = R.string.list_records_screen_label_empty_records),
            modifier = Modifier.then(emptyModifier)
        )
    }else{
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .then(listModifier)
        ){
            items(
                items = activityData,
                key = { it.id }
            ){
                    activity -> ActivityItem(activity = activity)
            }
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ActivityItem(
    activity: Activity,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colorScheme.background)
            .combinedClickable(
                onClick = {  },
                onLongClick = {
                    Log.d("asd123", "INTENTANDO ELIMINAR" + activity.description )
                }
            )
    ) {
        Divider(
            color = MaterialTheme.colorScheme.onBackground,
        )
        ActivityItemHeader(activity)
        ActivityItemContent(activity)
    }
}

@Composable
fun ActivityItemHeader(activity: Activity){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
    ){
        Text(
            text = activity.getPrintableType(LocalContext.current),
            color = MaterialTheme.colorScheme.onBackground,
            style = Typography.labelMedium,
        )
        Text(
            text = DateParse().simple(activity.createdAt),
            color = MaterialTheme.colorScheme.onBackground,
            style = Typography.labelMedium,
        )
    }
}

@Composable
fun ActivityItemContent(activity: Activity){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp)
    ){
        Text(
            text = activity.description,
            color = MaterialTheme.colorScheme.onBackground,
            style = Typography.bodyLarge,
            modifier = Modifier
                .weight(2f)
                .align(Alignment.CenterVertically)
        )
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .weight(1f)
        ){
            CalorieValue(activity)
        }
    }
}

@Composable
private fun CalorieValue(activity: Activity) {
    val highlightColor = if (isSystemInDarkTheme()) positiveBalanceDark else positiveBalanceLight
    Row{
        Text(
            text = activity.getPrintableKcal(),
            color = if(activity.isPerformingExercise()) highlightColor
                    else MaterialTheme.colorScheme.onBackground,
            style = Typography.titleLarge,
            fontWeight = FontWeight.Black
        )
        Text(
            text = stringResource(id = R.string.general_label_kcal),
            color = MaterialTheme.colorScheme.onBackground,
            style = Typography.labelMedium,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 2.dp)
        )
    }

}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ListAccountActivityPreview(){
    val activityData = mutableListOf<Activity>(
        Activity(
            id = UUID.randomUUID().toString(),
            kcal = 20,
            type = Activity.TYPE_CALORIE_INTAKE,
            description = "Hola como estás",
            createdAt = Date()
        ),
        Activity(
            id = UUID.randomUUID().toString(),
            kcal = 500,
            type = Activity.TYPE_PERFORMING_EXERCISE,
            description = "Hola como estás",
            createdAt = Date()
        ),
        Activity(
            id = UUID.randomUUID().toString(),
            kcal = 350,
            type = Activity.TYPE_CALORIE_INTAKE,
            description = "Hola como estás",
            createdAt = Date()
        ),
    )
    CalorieAccountTheme{
        ListAccountActivity(activityData)
    }
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ListAccountActivityEmptyPreview(){
    CalorieAccountTheme{
        ListAccountActivity(mutableListOf())
    }
}