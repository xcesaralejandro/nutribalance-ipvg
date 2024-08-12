package com.nutribalance.repositories

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.nutribalance.models.Activity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ActivityRepository (
    private val context: Context
){
    companion object {
        const val STORAGE_NAME = "activityRecords"
        const val ACTIVITY_LIST_KEY = "activityList"
    }
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(ActivityRepository.STORAGE_NAME, Context.MODE_PRIVATE)
    private val gson = Gson()
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()
    fun create(activity: Activity): Unit {
        val activityList = all().toMutableList()
        activityList.add(activity)
        val content = gson.toJson(activityList)
        editor.putString(ActivityRepository.ACTIVITY_LIST_KEY, content)
        editor.apply()
    }

    fun all(): MutableList<Activity> {
        val json = sharedPreferences.getString(ActivityRepository.ACTIVITY_LIST_KEY, null)
        if (json != null) {
            val type = object : TypeToken<List<Activity>>() {}.type
            val activities: List<Activity> = gson.fromJson(json, type)
            return activities.sortedByDescending { it.createdAt }.toMutableList()
        }
        return mutableListOf<Activity>()
    }

    fun getLastRecords(limit : Int = 10): MutableList<Activity> {
        val allActivities = all()
        if (limit >= allActivities.size) {
            return allActivities
        }
        return allActivities.take(limit).toMutableList()
    }

    fun total() : Int {
        val allActivities = all()
        var totalCalories = 0
        for (activity in allActivities) {
            when (activity.type) {
                Activity.TYPE_CALORIE_INTAKE -> totalCalories -= activity.kcal
                Activity.TYPE_PERFORMING_EXERCISE -> totalCalories += activity.kcal
            }
        }
        return totalCalories
    }
}