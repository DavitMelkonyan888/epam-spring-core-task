package com.example.gym.dao.impl;

import com.example.gym.dao.TraineeDAO;
import com.example.gym.model.Trainee;
import com.example.gym.storage.TraineeStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TraineeDAOImpl implements TraineeDAO {
    
    private static final Logger logger = LoggerFactory.getLogger(TraineeDAO.class);
    private TraineeStorage traineeStorage;
    
    @Autowired
    public void setStorage (TraineeStorage traineeStorage) {
        this.traineeStorage = traineeStorage;
    }
    
    @Override
    public List <Trainee> getAllTrainees () {
        logger.info("Fetching all trainees...");
        return new ArrayList <>(traineeStorage.getTrainees().values());
    }
    
    @Override
    public void save (Trainee trainee) {
        logger.info("Creating new Trainee: {} {} {}", trainee.getFirstName(), trainee.getLastName(), trainee.getUsername());
        Map <Long, Trainee> trainees = traineeStorage.getTrainees();
        if (trainees.containsKey(trainee.getId())) {
            logger.warn("Trainee with ID {} already exists!", trainee.getId());
        } else {
            trainees.put(trainee.getId(), trainee);
        }
        logger.debug("Trainee saved successfully: {}", trainee);
    }
    
    @Override
    public void update (Trainee trainee) {
        Map <Long, Trainee> trainees = traineeStorage.getTrainees();
        if (trainees.containsKey(trainee.getId())) {
            trainees.put(trainee.getId(), trainee);
            logger.debug("Trainee updated successfully: {}", trainee);
        } else {
            logger.error("Trainee not found with ID: {}", trainee.getId());
        }
    }
    
    @Override
    public void delete (long traineeId) {
        logger.info("Deleting Trainee with ID: {}", traineeId);
        Map<Long, Trainee> trainees = traineeStorage.getTrainees();
        if (trainees.containsKey(traineeId)) {
            trainees.remove(traineeId);
            logger.debug("Trainee with ID {} deleted successfully.", traineeId);
        } else {
            logger.warn("Attempted to delete non-existent Trainee with ID: {}", traineeId);
        }
    }
    
    @Override
    public Trainee get (long traineeId) {
        logger.info("Fetching Trainee with ID: {}", traineeId);
        Trainee trainee = traineeStorage.getTrainees().getOrDefault(traineeId, null);
        if (trainee == null) {
            logger.error("Trainee not found with ID: {}", traineeId);
        }
        return trainee;
    }
}
