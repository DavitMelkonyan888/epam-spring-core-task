package com.example.gym.dao.impl;

import com.example.gym.dao.TrainingTypeDAO;
import com.example.gym.model.Training;
import com.example.gym.model.TrainingType;
import com.example.gym.storage.TrainingTypeStorage;
import com.example.gym.storage.TrainingStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TrainingTypeDAOImpl implements TrainingTypeDAO {
    
    private TrainingTypeStorage trainingTypeStorage;
    
    @Autowired
    public void setStorage (TrainingTypeStorage trainingTypeStorage) {
        this.trainingTypeStorage = trainingTypeStorage;
    }
    
    @Override
    public void save (TrainingType trainingType) {
        Map <Long, TrainingType> trainingTypes = trainingTypeStorage.getTrainingTypes();
        if (trainingTypes.containsKey(trainingType.getId())) {
            System.out.println("\n!!!Training Type with ID " + trainingType.getId() + " already exists.!!!\n");
        } else {
            trainingTypes.put(trainingType.getId(), trainingType);
        }
    }
    
    @Override
    public List <TrainingType> getAllTrainingTypes () {
        return new ArrayList <>(trainingTypeStorage.getTrainingTypes().values());
    }
}
