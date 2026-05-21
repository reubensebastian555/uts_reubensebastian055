package com.example.makanbro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import com.example.makanbro.navigation.AppNavigation
import com.example.makanbro.storage.PreferenceManager
import com.example.makanbro.ui.theme.MakanbroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        val preferenceManager = PreferenceManager(this)
        
        setContent {
            val isDarkMode = preferenceManager.getBoolean(PreferenceManager.KEY_DARK_MODE, isSystemInDarkTheme())
            
            MakanbroTheme(darkTheme = isDarkMode) {
                AppNavigation(preferenceManager = preferenceManager)
            }
        }
    }
}
