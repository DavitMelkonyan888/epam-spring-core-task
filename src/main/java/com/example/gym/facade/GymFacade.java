package com.example.gym.facade;

import com.example.gym.model.Trainee;
import com.example.gym.model.Trainer;
import com.example.gym.model.Training;
import com.example.gym.model.TrainingType;
import com.example.gym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GymFacade {
    
    private TraineeService traineeService;
    private TrainerService trainerService;
    private TrainingService trainingService;
    
    @Autowired
    public GymFacade (TraineeService traineeService, TrainerService trainerService, TrainingService trainingService) {
        this.traineeService = traineeService;
        this.trainerService = trainerService;
        this.trainingService = trainingService;
    }
    
    public Trainer getTrainer (long trainerId) {
        return trainerService.getTrainer(trainerId);
    }
    
    public List<Trainer> getAllTrainers () {
        return trainerService.getAllTrainers();
    }
    
    
    
    
    
    
    public Trainee getTrainee (long traineeId) {
        return traineeService.getTrainee(traineeId);
    }
    
    public List<Trainee> getAllTrainees () {
        return traineeService.getAllTrainees();
    }
    
    
    
    
    
    
    
    public Training getTraining (long trainingId) {
        return trainingService.getTraining(trainingId);
    }
    
    public List<Training> getAllTrainings () {
        return trainingService.getAllTrainings();
    }
    
    
    
    
    
    
    public List<TrainingType> getAllTrainingTypes () {
        return trainingService.getAllTrainingTypes();
    }
    
    public void createTrainingType (TrainingType trainingType) {
        trainingService.createTrainingType(trainingType);
    }
}
