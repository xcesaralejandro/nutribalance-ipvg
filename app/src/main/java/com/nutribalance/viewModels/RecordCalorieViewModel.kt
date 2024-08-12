package com.nutribalance.viewModels

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import com.nutribalance.R
import com.nutribalance.models.Activity
import com.nutribalance.repositories.ActivityRepository
import java.util.Date
import java.util.UUID

class RecordCalorieViewModel : ViewModel() {

    var kcal by mutableStateOf("")
    var description by mutableStateOf("")
    var type by mutableStateOf(Activity.TYPE_CALORIE_INTAKE)

    fun getLabelForCalorieValue(context : Context ) : String {
        val textForCalorieIntake = context.getString(R.string.record_calories_screen_input_intake_calorie)
        val textForPerformingExercise = context.getString(R.string.record_calories_screen_input_performing_exercise_calorie)
        return if (type == Activity.TYPE_CALORIE_INTAKE) textForCalorieIntake else textForPerformingExercise
    }

    fun getLabelForActionDescription(context: Context) : String {
        val textForCalorieIntake = context.getString(R.string.record_calories_screen_input_intake_calorie_description)
        val textForPerformingExercise = context.getString(R.string.record_calories_screen_input_performing_exercise_calorie_description)
        return if (type == Activity.TYPE_CALORIE_INTAKE) textForCalorieIntake else textForPerformingExercise
    }

    fun storeActivity(context: Context) : Unit {
        if(validate(context)){
            val activityRepository = ActivityRepository(context)
            val uuid = UUID.randomUUID()
            activityRepository.create(
                Activity(
                    id = uuid.toString(),
                    kcal= Integer.parseInt(kcal),
                    type= type,
                    description = description,
                    createdAt = Date()
                )
            )
            reset()
        }
    }
    fun validate(context: Context) : Boolean {
        var hasValidData = true
        if(kcal.isEmpty() || description.isEmpty()){
            Toast.makeText(context, context.getString(R.string.validation_all_fields_required), Toast.LENGTH_SHORT).show()
            hasValidData = false
        }
        if(kcal.isNotEmpty() && kcal.toIntOrNull() == null){
            Toast.makeText(context, context.getString(R.string.validation_kcal_range), Toast.LENGTH_SHORT).show()
            hasValidData = false
        }
        if(kcal.toIntOrNull() != null && (kcal.toInt() <= 0 || kcal.toInt() >= 10000)){
            Toast.makeText(context, context.getString(R.string.validation_kcal_range), Toast.LENGTH_SHORT).show()
            hasValidData = false
        }
        return hasValidData
    }

    fun reset() {
        kcal = ""
        description = ""
        type = Activity.TYPE_CALORIE_INTAKE
    }
}