package com.quizapp.example.controller;

import com.quizapp.example.R;
import com.quizapp.example.model.QuestionModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AppController {
    private List<QuestionModel> questionModelList;
    private int level = 0;


    public AppController() {
        this.questionModelList = new ArrayList<>();
    }

    public void loadQuestion() {
//        questionModelList.add(new QuestionModel(R.drawable.uzbekistan, "", "daspeyodszea"));
        questionModelList.add(new QuestionModel(R.drawable.egypt, "egypt", "nqakrfrsmird"));               //1
        questionModelList.add(new QuestionModel(R.drawable.china, "china", "xynqftaokyqi"));      //2
        questionModelList.add(new QuestionModel(R.drawable.england, "england", "fdqargnylaqd"));   //3
        questionModelList.add(new QuestionModel(R.drawable.germany, "germany", "erangdaynfmq"));//4
        questionModelList.add(new QuestionModel(R.drawable.france, "france", "kfyatanosher"));//5
        questionModelList.add(new QuestionModel(R.drawable.israil, "israel", "oasrelodsiei"));//6
        questionModelList.add(new QuestionModel(R.drawable.italy, "italy", "posapyiytola"));//7
        questionModelList.add(new QuestionModel(R.drawable.spain, "spain", "nidyarsifagp"));//8
        questionModelList.add(new QuestionModel(R.drawable.turkey, "turkey", "ikdoraybusot"));//9
        questionModelList.add(new QuestionModel(R.drawable.korea, "korea", "bedarmqdkoky"));//10
        questionModelList.add(new QuestionModel(R.drawable.brazil, "brazil", "bedarazdkily"));//11
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(questionModelList);
    }

    public int getQuestionCount() {
        return questionModelList.size();
    }

    public QuestionModel getQuestion(int level) {//leveldagi indexni bizga qaytaradi !
        return questionModelList.get(level);
    }
}
