package com.quizapp.example.model;


import com.quizapp.example.contract.MainContract;
import com.quizapp.example.repository.AppRepository;

public class MainModel implements MainContract.MainModel {
    private AppRepository repository;

    public MainModel() {
            repository = AppRepository.getInstance();

    }
}
