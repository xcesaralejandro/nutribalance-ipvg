package com.nutribalance.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.nutribalance.ui.theme.CalorieAccountTheme
import com.nutribalance.ui.theme.Typography

@Composable
fun SectionHeader(title :String?, description :String?, modifier: Modifier = Modifier){
    Column (
        modifier = Modifier
            .wrapContentHeight()
            .then(modifier)
    ){
        title?.let { SectionTitle(it) }
        description?.let { SectionDescription(it) }
        HorizontalSpacer()
    }
}

@Composable
fun SectionTitle(text :String, modifier: Modifier = Modifier){
    Text(
        text = text.uppercase(),
        style = Typography.headlineMedium,
        fontWeight = FontWeight.Black,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .then(modifier)
    )
}

@Composable
fun SectionSubTitle(text :String, modifier: Modifier = Modifier){
    Text(
        text = text,
        style = Typography.headlineSmall,
        fontWeight = FontWeight.Black,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier.fillMaxWidth().then(modifier)
    )
    HorizontalSpacerSmall()
}
@Composable
fun SectionDivider(){
    Spacer(
        modifier = Modifier
            .height(25.dp)
    )
}

@Composable
fun SectionDescription(text : String){
    Text(
        text,
        color = MaterialTheme.colorScheme.onBackground,
        style = Typography.bodyLarge,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
}

@Composable
fun HorizontalSpacer(modifier: Modifier = Modifier){
    Spacer(modifier = Modifier
        .height(20.dp)
        .fillMaxWidth()
        .then(modifier)
    )
}

@Composable
fun HorizontalSpacerSmall(modifier: Modifier = Modifier){
    Spacer(modifier = Modifier
        .height(10.dp)
        .fillMaxWidth()
        .then(modifier)
    )
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SectionComponentsPreview(){
    CalorieAccountTheme {
        PageScrollableContainer (
            content = {
                SectionHeader("Title Section Header", "Description Section Header")
                SectionDivider()
                SectionTitle(text = "Only title")
                SectionDescription(text = "Only description")
                SectionSubTitle(text="Soy un subtitulo")
            }
        )
    }
}