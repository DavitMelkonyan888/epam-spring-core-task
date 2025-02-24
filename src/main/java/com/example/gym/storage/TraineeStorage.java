package com.example.gym.storage;

import com.example.gym.model.Trainee;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TraineeStorage {
    private final Map <Long, Trainee> trainees = new HashMap <>();
    
    public Map <Long, Trainee> getTrainees () {
        return trainees;
    }
}
