package com.example.gym.service;

import com.example.gym.model.Training;
import com.example.gym.model.TrainingType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainingService {
    
    void createTraining (Training training);
    
    Training getTraining (long trainingId);
    
    List <Training> getAllTrainings ();
    
    void createTrainingType (TrainingType trainingType);
    List<TrainingType> getAllTrainingTypes ();
}
