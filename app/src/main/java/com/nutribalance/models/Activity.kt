package com.nutribalance.models

import android.content.Context
import com.nutribalance.R
import java.util.Date

class Activity (
    var id: String,
    var kcal: Int,
    var type : String,
    var description: String,
    var createdAt : Date
){
    companion object {
        const val TYPE_CALORIE_INTAKE = "calorie-intake"
        const val TYPE_PERFORMING_EXERCISE = "performing-exercise"
    }

    fun getPrintableKcal() : String {
        var prefix = ""
        when(type){
            TYPE_CALORIE_INTAKE -> prefix = "-"
            TYPE_PERFORMING_EXERCISE -> prefix = "+"
        }
        return "${prefix}${kcal}"
    }

    fun getPrintableType(context : Context) : String {
        var printable = ""
        when(type){
            TYPE_CALORIE_INTAKE -> printable = context.getString(R.string.record_calories_screen_label_record_type_intake)
            TYPE_PERFORMING_EXERCISE -> printable = context.getString(R.string.record_calories_screen_label_record_type_performing_exercise)
        }
        return printable
    }

    fun isCalorieIntake() : Boolean {
        return type == TYPE_CALORIE_INTAKE
    }

    fun isPerformingExercise() : Boolean {
        return type == TYPE_PERFORMING_EXERCISE
    }
}