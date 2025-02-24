package com.example.gym.storage;

import com.example.gym.model.TrainingType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TrainingTypeStorage {
    private final Map <Long, TrainingType> trainingTypes = new HashMap <>();
    
    public Map <Long, TrainingType> getTrainingTypes () {
        return trainingTypes;
    }
}
