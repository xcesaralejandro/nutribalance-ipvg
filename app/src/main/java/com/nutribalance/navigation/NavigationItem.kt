package com.nutribalance.navigation

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import com.nutribalance.R

sealed class NavigationItem(var route: String, val icon: ImageVector?, var title: String) {
    class Home(context: Context) : NavigationItem(
        AppScreens.HomeScreen.route,
        Icons.Rounded.Home,
        context.getString(R.string.navigation_home)
    )

    class Config(context: Context) : NavigationItem(
        AppScreens.ConfigScreen.route,
        Icons.Rounded.Settings,
        context.getString(R.string.navigation_config)
    )

    class RecordCalories(context: Context) : NavigationItem(
        AppScreens.RecordCaloriesScreen.route,
        Icons.Rounded.Add,
        context.getString(R.string.navigation_new_record)
    )
}