package com.example.gym.service.impl;

import com.example.gym.dao.TraineeDAO;
import com.example.gym.dao.TrainerDAO;
import com.example.gym.model.Trainee;
import com.example.gym.service.TraineeService;
import com.example.gym.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TraineeServiceImpl implements TraineeService {
    
    private TraineeDAO traineeDAO;
    private TrainerDAO trainerDAO;
    
    @Autowired
    public void setTraineeDAO (TraineeDAO traineeDAO) {
        this.traineeDAO = traineeDAO;
    }
    
    @Autowired
    public void setTrainerDAO (TrainerDAO trainerDAO) {
        this.trainerDAO = trainerDAO;
    }
    
    @Override
    public void createTrainee (Trainee trainee) {
        String username = UsernameGenerator.generate(trainee.getFirstName(), trainee.getLastName(), traineeDAO.getAllTrainees(), trainerDAO.getAllTrainers());
        String password = PasswordGenerator.generate();
        trainee.setUsername(username);
        trainee.setPassword(password);
        traineeDAO.save(trainee);
    }
    
    @Override
    public void updateTrainee (Trainee trainee) {
        traineeDAO.update(trainee);
    }
    
    @Override
    public void deleteTrainee (long traineeId) {
        traineeDAO.delete(traineeId);
    }
    
    @Override
    public Trainee getTrainee (long traineeId) {
        return traineeDAO.get(traineeId);
    }
    
    @Override
    public List <Trainee> getAllTrainees () {
        return traineeDAO.getAllTrainees();
    }
}
