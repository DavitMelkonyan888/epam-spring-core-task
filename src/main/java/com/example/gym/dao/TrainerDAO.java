package com.example.gym.dao;

import com.example.gym.model.Trainer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TrainerDAO {
    
    List<Trainer> getAllTrainers ();
    
    void save (Trainer trainer);
    
    void update (Trainer trainer);
    
    Trainer get (long trainerId);
}
