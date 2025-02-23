package com.example.gym.storage;

import com.example.gym.model.Trainer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TrainerStorage {
    private final Map <Long, Trainer> trainers = new HashMap <>();
    
    public Map <Long, Trainer> getTrainers () {
        return trainers;
    }
}
