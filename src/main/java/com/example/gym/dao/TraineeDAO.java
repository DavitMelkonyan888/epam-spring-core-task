package com.example.gym.dao;

import com.example.gym.model.Trainee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TraineeDAO {
    
    List<Trainee> getAllTrainees ();
    
    void save (Trainee trainee);
    
    void update (Trainee trainee);
    
    void delete (long traineeId);
    
    Trainee get (long traineeId);
}
