package com.example.gym.dao.impl;

import com.example.gym.dao.TrainingTypeDAO;
import com.example.gym.model.TrainingType;
import com.example.gym.storage.TrainingTypeStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TrainingTypeDAOImpl implements TrainingTypeDAO {
    
    private static final Logger logger = LoggerFactory.getLogger(TrainingTypeDAOImpl.class);
    private TrainingTypeStorage trainingTypeStorage;
    
    @Autowired
    public void setStorage (TrainingTypeStorage trainingTypeStorage) {
        this.trainingTypeStorage = trainingTypeStorage;
    }
    
    @Override
    public void save (TrainingType trainingType) {
        logger.info("Saving new Training Type: {}", trainingType.getName());
        Map <Long, TrainingType> trainingTypes = trainingTypeStorage.getTrainingTypes();
        if (trainingTypes.containsKey(trainingType.getId())) {
            logger.warn("Training Type with ID {} already exists!", trainingType.getId());
        } else {
            trainingTypes.put(trainingType.getId(), trainingType);
            logger.debug("Training Type saved successfully: {}", trainingType);
        }
    }
    
    @Override
    public List <TrainingType> getAllTrainingTypes () {
        logger.info("Fetching all training types...");
        return new ArrayList <>(trainingTypeStorage.getTrainingTypes().values());
    }
    
    @Override
    public TrainingType getTrainingType (long trainingTypeId) {
        logger.info("Fetching Training Type with ID: {}", trainingTypeId);
        TrainingType trainingType = trainingTypeStorage.getTrainingTypes().getOrDefault(trainingTypeId, null);
        
        if (trainingType == null) {
            logger.error("Training Type not found with ID: {}", trainingTypeId);
        }
        
        return trainingType;
    }
}
