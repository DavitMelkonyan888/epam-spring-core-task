package com.example.gym.service.impl;

import com.example.gym.dao.TrainingDAO;
import com.example.gym.dao.TrainingTypeDAO;
import com.example.gym.model.Training;
import com.example.gym.model.TrainingType;
import com.example.gym.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TrainingServiceImpl implements TrainingService {
    
    private TrainingDAO trainingDAO;
    private TrainingTypeDAO trainingTypeDAO;
    
    @Autowired
    public void setTrainingDAO (TrainingDAO trainingDAO) {
        this.trainingDAO = trainingDAO;
    }
    
    @Autowired
    public void setTrainingTypeDAO (TrainingTypeDAO trainingTypeDAO) {
        this.trainingTypeDAO = trainingTypeDAO;
    }
    
    @Override
    public void createTraining (Training training) {
        trainingDAO.save(training);
    }
    
    @Override
    public Training getTraining (long trainingId) {
        return trainingDAO.get(trainingId);
    }
    
    @Override
    public List <Training> getAllTrainings () {
        return trainingDAO.getAllTrainings();
    }
    
    @Override
    public void createTrainingType (TrainingType trainingType) {
        trainingTypeDAO.save(trainingType);
    }
    
    @Override
    public List <TrainingType> getAllTrainingTypes () {
        return trainingTypeDAO.getAllTrainingTypes();
    }
    
    @Override
    public TrainingType getTrainingType (long trainingTypeId) {
        return trainingTypeDAO.getTrainingType(trainingTypeId);
    }
}
