package com.example.makanbro.storage

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("makanbro_prefs", Context.MODE_PRIVATE)

    fun saveString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun saveBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    companion object {
        const val KEY_RESTAURANT_NAME = "restaurant_name"
        const val KEY_ADDRESS = "address"
        const val KEY_DESCRIPTION = "description"
        const val KEY_OPENING_HOURS = "opening_hours"
        const val KEY_DARK_MODE = "dark_mode"
    }
}
