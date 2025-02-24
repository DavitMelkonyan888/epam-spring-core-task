package com.example.gym.service;

import com.example.gym.model.Trainer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainerService {
    void createTrainer (Trainer trainer);
    void updateTrainer (Trainer trainer);
    Trainer getTrainer(long trainerId);
    List <Trainer> getAllTrainers ();
}
