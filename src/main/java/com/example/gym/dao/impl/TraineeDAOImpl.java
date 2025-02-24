package com.example.gym.dao.impl;

import com.example.gym.dao.TraineeDAO;
import com.example.gym.model.Trainee;
import com.example.gym.storage.TraineeStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TraineeDAOImpl implements TraineeDAO {
    
    private TraineeStorage traineeStorage;
    
    @Autowired
    public void setStorage (TraineeStorage traineeStorage) {
        this.traineeStorage = traineeStorage;
    }
    
    @Override
    public List <Trainee> getAllTrainees () {
        return new ArrayList <>(traineeStorage.getTrainees().values());
    }
    
    @Override
    public void save (Trainee trainee) {
        Map <Long, Trainee> trainees = traineeStorage.getTrainees();
        if (trainees.containsKey(trainee.getId())) {
            System.out.println("\n!!!Trainee with ID " + trainee.getId() + " already exists.!!!\n");
        } else {
            trainees.put(trainee.getId(), trainee);
        }
    }
    
    @Override
    public void update (Trainee trainee) {
        Map <Long, Trainee> trainees = traineeStorage.getTrainees();
        if (trainees.containsKey(trainee.getId())) {
            trainees.put(trainee.getId(), trainee);
        } else {
            System.out.println("\n!!!Trainee with ID " + trainee.getId() + " not found.!!!\n");
        }
    }
    
    @Override
    public void delete (long traineeId) {
        Map<Long, Trainee> trainees = traineeStorage.getTrainees();
        if (trainees.containsKey(traineeId)) {
            trainees.remove(traineeId);
        } else {
            System.out.println("\n!!!Trainee with ID " + traineeId + " not found.!!!\n");
        }
    }
    
    @Override
    public Trainee get (long traineeId) {
        return traineeStorage.getTrainees().getOrDefault(traineeId, null);
    }
}
