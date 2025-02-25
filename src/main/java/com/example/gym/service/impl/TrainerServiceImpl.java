package com.example.gym.service.impl;

import com.example.gym.dao.TraineeDAO;
import com.example.gym.dao.TrainerDAO;
import com.example.gym.model.Trainer;
import com.example.gym.service.TrainerService;
import com.example.gym.utils.PasswordGenerator;
import com.example.gym.utils.UsernameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TrainerServiceImpl implements TrainerService {
    
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
    public void createTrainer (Trainer trainer) {
        String username = UsernameGenerator.generate(trainer.getFirstName(), trainer.getLastName(), traineeDAO.getAllTrainees(), trainerDAO.getAllTrainers());
        String password = PasswordGenerator.generate();
        trainer.setUsername(username);
        trainer.setPassword(password);
        trainerDAO.save(trainer);
    }
    
    @Override
    public void updateTrainer (Trainer trainer) {
        String username = UsernameGenerator.generate(trainer.getFirstName(), trainer.getLastName(), traineeDAO.getAllTrainees(), trainerDAO.getAllTrainers());
        String password = PasswordGenerator.generate();
        trainer.setUsername(username);
        trainer.setPassword(password);
        trainerDAO.update(trainer);
    }
    
    @Override
    public Trainer getTrainer (long trainerId) {
        return trainerDAO.get(trainerId);
    }
    
    @Override
    public List <Trainer> getAllTrainers () {
        return trainerDAO.getAllTrainers();
    }
}
