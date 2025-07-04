package com.quizapp.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.quizapp.example.R;

public class SettingsActivity extends AppCompatActivity {
    
    private Switch switchDarkMode;
    private ImageView ivBack;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "app_settings";
    private static final String DARK_MODE_KEY = "dark_mode";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        
        initViews();
        setupDarkModeToggle();
    }
    
    private void initViews() {
        ivBack = findViewById(R.id.ivBackSettings);
        switchDarkMode = findViewById(R.id.switchDarkMode);
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        
        ivBack.setOnClickListener(v -> finish());
        
        // Load current dark mode state
        boolean isDarkMode = sharedPreferences.getBoolean(DARK_MODE_KEY, false);
        switchDarkMode.setChecked(isDarkMode);
    }
    
    private void setupDarkModeToggle() {
        switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Save preference
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(DARK_MODE_KEY, isChecked);
            editor.apply();
            
            // Apply dark mode
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            
            // Recreate activity to apply changes
            recreate();
        });
    }
}