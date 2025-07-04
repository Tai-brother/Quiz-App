package com.quizapp.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.quizapp.example.R;
import com.quizapp.example.adapter.CustomQuestionsAdapter;
import com.quizapp.example.local_data.QuizPref;
import com.quizapp.example.model.CustomQuestionModel;
import com.quizapp.example.util.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MyQuestionsActivity extends AppCompatActivity {
    
    private RecyclerView rvMyQuestions;
    private TextView tvEmptyState, tvTotalQuestions;
    private ImageView ivBack;
    private QuizPref quizPref;
    private CustomQuestionsAdapter adapter;
    private List<CustomQuestionModel> customQuestions;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_questions);
        
        initViews();
        loadCustomQuestions();
        setupRecyclerView();
    }
    
    private void initViews() {
        quizPref = QuizPref.getInstance();
        
        ivBack = findViewById(R.id.ivBackMyQuestions);
        rvMyQuestions = findViewById(R.id.rvMyQuestions);
        tvEmptyState = findViewById(R.id.tvEmptyState);
        tvTotalQuestions = findViewById(R.id.tvTotalQuestions);
        
        ivBack.setOnClickListener(v -> finish());
        
        findViewById(R.id.btnStartCustomQuiz).setOnClickListener(v -> startCustomQuiz());
    }
    
    private void loadCustomQuestions() {
        String json = quizPref.getCustomQuestions();
        if (json.isEmpty()) {
            customQuestions = new ArrayList<>();
        } else {
            Gson gson = new Gson();
            Type type = new TypeToken<List<CustomQuestionModel>>(){}.getType();
            customQuestions = gson.fromJson(json, type);
        }
        
        updateUI();
    }
    
    private void setupRecyclerView() {
        adapter = new CustomQuestionsAdapter(customQuestions, this);
        rvMyQuestions.setLayoutManager(new LinearLayoutManager(this));
        rvMyQuestions.setAdapter(adapter);
    }
    
    private void updateUI() {
        if (customQuestions.isEmpty()) {
            tvEmptyState.setVisibility(View.VISIBLE);
            rvMyQuestions.setVisibility(View.GONE);
            tvTotalQuestions.setText("Tổng câu hỏi: 0");
        } else {
            tvEmptyState.setVisibility(View.GONE);
            rvMyQuestions.setVisibility(View.VISIBLE);
            tvTotalQuestions.setText("Tổng câu hỏi: " + customQuestions.size());
        }
    }
    
    private void startCustomQuiz() {
        if (customQuestions.size() < 5) {
            android.widget.Toast.makeText(this, 
                "Cần ít nhất 5 câu hỏi để bắt đầu quiz", 
                android.widget.Toast.LENGTH_SHORT).show();
            return;
        }
        
        Intent intent = new Intent(this, CustomQuizActivity.class);
        startActivity(intent);
    }
    
    public void deleteQuestion(int position) {
        customQuestions.remove(position);
        adapter.notifyItemRemoved(position);
        
        Gson gson = new Gson();
        String json = gson.toJson(customQuestions);
        quizPref.saveCustomQuestions(json);
        
        updateUI();
        android.widget.Toast.makeText(this, "Đã xóa câu hỏi", android.widget.Toast.LENGTH_SHORT).show();
    }
}