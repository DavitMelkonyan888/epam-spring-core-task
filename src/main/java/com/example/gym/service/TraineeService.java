package com.example.gym.service;

import com.example.gym.model.Trainee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TraineeService {
    void createTrainee (Trainee trainee);
    void updateTrainee(Trainee trainee);
    void deleteTrainee(long traineeId);
    Trainee getTrainee(long traineeId);
    List <Trainee> getAllTrainees ();
}
