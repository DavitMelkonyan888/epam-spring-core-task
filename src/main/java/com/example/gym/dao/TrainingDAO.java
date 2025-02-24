package com.example.gym.dao;

import com.example.gym.model.Training;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TrainingDAO {
    
    void save (Training training);
    
    Training get (long trainingId);
    
    List<Training> getAllTrainings ();
}
