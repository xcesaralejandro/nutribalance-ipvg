package com.nutribalance.repositories

import android.content.Context
import android.content.SharedPreferences


class ConfigRepository (
    private val context: Context
){
    companion object {
        const val STORAGE_NAME = "configRepository"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(ActivityRepository.STORAGE_NAME, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()
    /*
    fun create(activity: Activity): Unit {
        val activityList = all().toMutableList()
        activityList.add(activity)
        val content = gson.toJson(activityList)
        editor.putString(ActivityRepository.ACTIVITY_LIST_KEY, content)
        editor.apply()
    }
    */

}