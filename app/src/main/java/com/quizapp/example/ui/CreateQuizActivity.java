package com.quizapp.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.quizapp.example.R;
import com.quizapp.example.local_data.QuizPref;
import com.quizapp.example.model.CustomQuestionModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CreateQuizActivity extends AppCompatActivity {
    
    private EditText etQuestion, etOption1, etOption2, etOption3, etOption4;
    private RadioGroup rgCorrectAnswer;
    private Button btnSaveQuestion, btnViewMyQuestions;
    private ImageView ivBack;
    private QuizPref quizPref;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);
        
        initViews();
        setupClickListeners();
    }
    
    private void initViews() {
        quizPref = QuizPref.getInstance();
        
        ivBack = findViewById(R.id.ivBackCreateQuiz);
        etQuestion = findViewById(R.id.etQuestion);
        etOption1 = findViewById(R.id.etOption1);
        etOption2 = findViewById(R.id.etOption2);
        etOption3 = findViewById(R.id.etOption3);
        etOption4 = findViewById(R.id.etOption4);
        rgCorrectAnswer = findViewById(R.id.rgCorrectAnswer);
        btnSaveQuestion = findViewById(R.id.btnSaveQuestion);
        btnViewMyQuestions = findViewById(R.id.btnViewMyQuestions);
    }
    
    private void setupClickListeners() {
        ivBack.setOnClickListener(v -> finish());
        
        btnSaveQuestion.setOnClickListener(v -> saveQuestion());
        
        btnViewMyQuestions.setOnClickListener(v -> {
            Intent intent = new Intent(CreateQuizActivity.this, MyQuestionsActivity.class);
            startActivity(intent);
        });
    }
    
    private void saveQuestion() {
        String question = etQuestion.getText().toString().trim();
        String option1 = etOption1.getText().toString().trim();
        String option2 = etOption2.getText().toString().trim();
        String option3 = etOption3.getText().toString().trim();
        String option4 = etOption4.getText().toString().trim();
        
        if (question.isEmpty() || option1.isEmpty() || option2.isEmpty() || 
            option3.isEmpty() || option4.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }
        
        int selectedId = rgCorrectAnswer.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this, "Please select correct answer", Toast.LENGTH_SHORT).show();
            return;
        }
        
        int correctAnswerIndex = getCorrectAnswerIndex(selectedId);
        
        CustomQuestionModel customQuestion = new CustomQuestionModel(
            question, option1, option2, option3, option4, correctAnswerIndex
        );
        
        saveCustomQuestion(customQuestion);
        
        Toast.makeText(this, "Question saved successfully!", Toast.LENGTH_SHORT).show();
        clearForm();
    }
    
    private int getCorrectAnswerIndex(int selectedId) {
        if (selectedId == R.id.rbOption1) return 0;
        if (selectedId == R.id.rbOption2) return 1;
        if (selectedId == R.id.rbOption3) return 2;
        if (selectedId == R.id.rbOption4) return 3;
        return 0;
    }
    
    private void saveCustomQuestion(CustomQuestionModel question) {
        List<CustomQuestionModel> customQuestions = getCustomQuestions();
        customQuestions.add(question);
        
        Gson gson = new Gson();
        String json = gson.toJson(customQuestions);
        quizPref.saveCustomQuestions(json);
    }
    
    private List<CustomQuestionModel> getCustomQuestions() {
        String json = quizPref.getCustomQuestions();
        if (json.isEmpty()) {
            return new ArrayList<>();
        }
        
        Gson gson = new Gson();
        Type type = new TypeToken<List<CustomQuestionModel>>(){}.getType();
        return gson.fromJson(json, type);
    }
    
    private void clearForm() {
        etQuestion.setText("");
        etOption1.setText("");
        etOption2.setText("");
        etOption3.setText("");
        etOption4.setText("");
        rgCorrectAnswer.clearCheck();
    }
}