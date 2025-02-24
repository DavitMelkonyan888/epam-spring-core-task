package com.example.gym.dao.impl;

import com.example.gym.dao.TrainingDAO;
import com.example.gym.model.Trainer;
import com.example.gym.model.Training;
import com.example.gym.storage.TrainingStorage;
import com.example.gym.storage.TrainerStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TrainingDAOImpl implements TrainingDAO {
    
    private TrainingStorage trainingStorage;
    
    @Autowired
    public void setStorage (TrainingStorage trainingStorage) {
        this.trainingStorage = trainingStorage;
    }
    
    @Override
    public void save (Training training) {
        Map <Long, Training> trainings = trainingStorage.getTrainings();
        if (trainings.containsKey(training.getId())) {
            System.out.println("\n!!!Training with ID " + training.getId() + " already exists.!!!\n");
        } else {
            trainings.put(training.getId(), training);
        }
    }
    
    @Override
    public Training get (long trainingId) {
        return trainingStorage.getTrainings().getOrDefault(trainingId, null);
    }
    
    @Override
    public List <Training> getAllTrainings () {
        return new ArrayList <>(trainingStorage.getTrainings().values());
    }
}
