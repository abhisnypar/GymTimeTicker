package com.example.saiabhinaypidugu.gymtimeticker.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.saiabhinaypidugu.gymtimeticker.BuildConfig

class DataProvider {

    companion object {
        fun getSharedPreferences(context: Context): SharedPreferences = context.getSharedPreferences(BuildConfig.SHARED_PREFS, Context.MODE_PRIVATE)

        fun saveHoursData(context: Context, hoursValue: Int, key: String) {
            getSharedPreferences(context).edit().putInt("$key:HOURS", hoursValue).apply()
        }

        fun saveMinutesData(context: Context, minutesValue: Int, key: String) {
            getSharedPreferences(context).edit().putInt("$key:MINUTES", minutesValue).apply()
        }

        fun saveSecondsData(context: Context, secondsValue: Int, key: String) {
            getSharedPreferences(context).edit().putInt("$key:SECONDS", secondsValue).apply()
        }

        fun saveInterVelTime(context: Context, intervalTime: Long, key: String){
            getSharedPreferences(context).edit().putLong(key, intervalTime).apply()
        }

        fun saveCountDowTime(context: Context, intervalTime: Long, key: String){
            getSharedPreferences(context).edit().putLong(key, intervalTime).apply()
        }
    }
}