package com.example.gym.dao.impl;

import com.example.gym.dao.TrainerDAO;
import com.example.gym.model.Trainee;
import com.example.gym.model.Trainer;
import com.example.gym.storage.TrainerStorage;
import com.example.gym.storage.TraineeStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TrainerDAOImpl implements TrainerDAO {
    
    private TrainerStorage trainerStorage;
    
    @Autowired
    public void setStorage (TrainerStorage trainerStorage) {
        this.trainerStorage = trainerStorage;
    }
    
    @Override
    public List <Trainer> getAllTrainers () {
        return new ArrayList <>(trainerStorage.getTrainers().values());
    }
    
    @Override
    public void save (Trainer trainer) {
        Map <Long, Trainer> trainers = trainerStorage.getTrainers();
        if (trainers.containsKey(trainer.getId())) {
            System.out.println("\n!!!Trainer with ID " + trainer.getId() + " already exists.!!!\n");
        } else {
            trainers.put(trainer.getId(), trainer);
        }
    }
    
    @Override
    public void update (Trainer trainer) {
        Map <Long, Trainer> trainers = trainerStorage.getTrainers();
        if (trainers.containsKey(trainer.getId())) {
            trainers.put(trainer.getId(), trainer);
        } else {
            System.out.println("\n!!!Trainer with ID " + trainer.getId() + " not found.!!!\n");
        }
    }
    
    @Override
    public Trainer get (long trainerId) {
        return trainerStorage.getTrainers().getOrDefault(trainerId, null);
    }
}
