package com.example.gym.dao.impl;

import com.example.gym.dao.TrainingDAO;
import com.example.gym.model.Training;
import com.example.gym.storage.TrainingStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TrainingDAOImpl implements TrainingDAO {
    
    private static final Logger logger = LoggerFactory.getLogger(TrainingDAOImpl.class);
    private TrainingStorage trainingStorage;
    
    @Autowired
    public void setStorage (TrainingStorage trainingStorage) {
        this.trainingStorage = trainingStorage;
    }
    
    @Override
    public void save (Training training) {
        logger.info("Saving new Training: {} for Trainee ID: {} with Trainer ID: {}", training.getName(), training.getTraineeId(), training.getTrainerId());
        Map <Long, Training> trainings = trainingStorage.getTrainings();
        if (trainings.containsKey(training.getId())) {
            logger.warn("Training with ID {} already exists!", training.getId());
        } else {
            trainings.put(training.getId(), training);
            logger.debug("Training saved successfully: {}", training);
        }
    }
    
    @Override
    public Training get (long trainingId) {
        logger.info("Fetching Training with ID: {}", trainingId);
        Training training = trainingStorage.getTrainings().getOrDefault(trainingId, null);
        
        if (training == null) {
            logger.error("Training not found with ID: {}", trainingId);
        }
        
        return training;
    }
    
    @Override
    public List <Training> getAllTrainings () {
        logger.info("Fetching all trainings...");
        return new ArrayList <>(trainingStorage.getTrainings().values());
    }
}
