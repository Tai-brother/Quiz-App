package com.quizapp.example.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;

import com.quizapp.example.local_data.QuizPref;
import com.quizapp.example.local_data.source.Base;
import com.quizapp.example.local_data.source.LocalPref;

public class App extends Application {
    public static Context cnt;
    private static final String PREFS_NAME = "app_settings";
    private static final String DARK_MODE_KEY = "dark_mode";
    
    @Override
    public void onCreate() {
        super.onCreate();
        cnt = this;
        Base.init(this);
        QuizPref.init(this);
        
        // Apply saved dark mode preference
        applyDarkModePreference();
    }
    
    private void applyDarkModePreference() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean isDarkMode = sharedPreferences.getBoolean(DARK_MODE_KEY, false);
        
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}