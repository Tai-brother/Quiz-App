package com.quizapp.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.quizapp.example.R;
import com.quizapp.example.local_data.QuizPref;

public class HomeActivity extends AppCompatActivity {
    TextView userNameHome;
    CardView cvStartQuiz, cvRule, cvHistory, cvCreateQuiz, cvAbout;
    ImageView ivSettings;
    QuizPref quizPref;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        userNameHome.setText("Hello " + quizPref.getName());
        
        cvHistory.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, HistoryActivity.class));
        });
        
        cvAbout.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, AboutActivity.class));
        });
        
        cvStartQuiz.setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this, QuizOptionActivity.class));
        });
        
        cvCreateQuiz.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, CreateQuizActivity.class));
        });
        
        cvRule.setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this, RulesActivity.class));
        });
        
        // Settings button click
        ivSettings.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
        });
    }

    public void initView() {
        cvStartQuiz = findViewById(R.id.cvStartQuiz);
        cvRule = findViewById(R.id.cvRule);
        cvAbout = findViewById(R.id.cvEditPassword);
        cvHistory = findViewById(R.id.cvHistory);
        cvCreateQuiz = findViewById(R.id.cvCreateQuiz);
        ivSettings = findViewById(R.id.ivSettings);
        userNameHome = (TextView) findViewById(R.id.tvUsernameHome);
        quizPref = QuizPref.getInstance();
    }

    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
        finish();
        super.onBackPressed();
    }
}