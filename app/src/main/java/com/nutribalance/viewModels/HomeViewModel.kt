package com.nutribalance.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.nutribalance.models.Activity
import com.nutribalance.repositories.ActivityRepository

class HomeViewModel : ViewModel() {

    companion object {
        const val LAST_ACTIVITY_ITEMS_COUNT = 10
    }
    fun getTotal(context: Context) : Int {
        val activityRepository = ActivityRepository(context)
        return activityRepository.total()
    }


    fun getLastActivity(context: Context) : MutableList<Activity> {
        val activityRepository = ActivityRepository(context)
        return activityRepository.getLastRecords(HomeViewModel.LAST_ACTIVITY_ITEMS_COUNT)
    }

}