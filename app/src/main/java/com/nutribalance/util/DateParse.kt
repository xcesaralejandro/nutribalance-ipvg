package com.nutribalance.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateParse {

    fun toFriendly(date: Date): String {
        val outputFormat = SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault())
        return outputFormat.format(date)
    }

    fun simple(date: Date): String {
        val outputFormat = SimpleDateFormat("dd MMM HH:mm", Locale.getDefault())
        return outputFormat.format(date)
    }
}
