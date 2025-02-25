package com.example.gym.dao;

import com.example.gym.model.TrainingType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TrainingTypeDAO {
    
    void save (TrainingType trainingType);
    
    List<TrainingType> getAllTrainingTypes ();
    
    TrainingType getTrainingType (long trainingTypeId);
}
