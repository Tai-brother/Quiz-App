package com.quizapp.example.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.quizapp.example.R;
import com.quizapp.example.model.CustomQuestionModel;
import com.quizapp.example.ui.MyQuestionsActivity;

import java.util.List;

public class CustomQuestionsAdapter extends RecyclerView.Adapter<CustomQuestionsAdapter.ViewHolder> {
    
    private List<CustomQuestionModel> questions;
    private MyQuestionsActivity activity;
    
    public CustomQuestionsAdapter(List<CustomQuestionModel> questions, MyQuestionsActivity activity) {
        this.questions = questions;
        this.activity = activity;
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_custom_question, parent, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CustomQuestionModel question = questions.get(position);
        
        holder.tvQuestion.setText(question.getQuestion());
        holder.tvCorrectAnswer.setText("Đáp án: " + question.getCorrectAnswer());
        holder.tvCorrectAnswer.setVisibility(View.GONE);
        holder.btnShowQuestion.setVisibility(View.VISIBLE);
        
        holder.btnShowQuestion.setOnClickListener(v -> {
            holder.tvCorrectAnswer.setVisibility(View.VISIBLE);
            holder.btnShowQuestion.setVisibility(View.GONE);
        });
        
        holder.ivDelete.setOnClickListener(v -> {
            activity.deleteQuestion(position);
        });
    }
    
    @Override
    public int getItemCount() {
        return questions.size();
    }
    
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuestion, tvCorrectAnswer;
        ImageView ivDelete;
        CardView cardView;
        Button btnShowQuestion;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuestion = itemView.findViewById(R.id.tvQuestionItem);
            tvCorrectAnswer = itemView.findViewById(R.id.tvCorrectAnswerItem);
            ivDelete = itemView.findViewById(R.id.ivDeleteQuestion);
            cardView = itemView.findViewById(R.id.cvQuestionItem);
            btnShowQuestion = itemView.findViewById(R.id.btnShowQuestion);
        }
    }
}