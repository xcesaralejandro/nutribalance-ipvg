package com.nutribalance.navigation

sealed class AppScreens (
    val route: String
){
    object HomeScreen: AppScreens("HomeScreen")
    object ConfigScreen: AppScreens("ConfigScreen")
    object RecordCaloriesScreen: AppScreens("RecordCaloriesScreen")
    object ListRecordsScreen: AppScreens("ListRecordsScreen")
}
