package com.example.gym.dao.impl;

import com.example.gym.dao.TrainerDAO;
import com.example.gym.model.Trainer;
import com.example.gym.storage.TrainerStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TrainerDAOImpl implements TrainerDAO {
    
    private static final Logger logger = LoggerFactory.getLogger(TrainerDAOImpl.class);
    private TrainerStorage trainerStorage;
    
    @Autowired
    public void setStorage (TrainerStorage trainerStorage) {
        this.trainerStorage = trainerStorage;
    }
    
    @Override
    public List <Trainer> getAllTrainers () {
        logger.info("Fetching all trainers...");
        return new ArrayList <>(trainerStorage.getTrainers().values());
    }
    
    @Override
    public void save (Trainer trainer) {
        logger.info("Creating new Trainer: {} {} ({})", trainer.getFirstName(), trainer.getLastName(), trainer.getUsername());
        Map <Long, Trainer> trainers = trainerStorage.getTrainers();
        if (trainers.containsKey(trainer.getId())) {
            logger.warn("Trainer with ID {} already exists!", trainer.getId());
        } else {
            trainers.put(trainer.getId(), trainer);
            logger.debug("Trainer saved successfully: {}", trainer);
        }
    }
    
    @Override
    public void update (Trainer trainer) {
        Map <Long, Trainer> trainers = trainerStorage.getTrainers();
        if (trainers.containsKey(trainer.getId())) {
            trainers.put(trainer.getId(), trainer);
            logger.debug("Trainer updated successfully: {}", trainer);
        } else {
            logger.error("Trainer not found with ID: {}", trainer.getId());
        }
    }
    
    @Override
    public Trainer get (long trainerId) {
        logger.info("Fetching Trainer with ID: {}", trainerId);
        Trainer trainer = trainerStorage.getTrainers().getOrDefault(trainerId, null);
        
        if (trainer == null) {
            logger.error("Trainer not found with ID: {}", trainerId);
        }
        
        return trainer;
    }
}
