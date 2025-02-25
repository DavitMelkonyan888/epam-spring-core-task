package com.example.gym.facade;

import com.example.gym.model.Trainee;
import com.example.gym.model.Trainer;
import com.example.gym.model.Training;
import com.example.gym.model.TrainingType;
import com.example.gym.service.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Component
@PropertySource ( value = "classpath:/application.properties" )
public class GymFacade implements InitializingBean {
    
    private TraineeService traineeService;
    private TrainerService trainerService;
    private TrainingService trainingService;
    
    @Value ( "${storage.path.trainings}" )
    private String trainingsPath;
    @Value ( "${storage.path.trainers}" )
    private String trainersPath;
    @Value ( "${storage.path.trainees}" )
    private String traineesPath;
    @Value ( "${storage.path.training-types}" )
    private String trainingTypesPath;
    
    @Autowired
    public GymFacade (TraineeService traineeService, TrainerService trainerService, TrainingService trainingService) {
        this.traineeService = traineeService;
        this.trainerService = trainerService;
        this.trainingService = trainingService;
    }
    
    @Override
    public void afterPropertiesSet () {
        
        String[] paths = {trainersPath, traineesPath, trainingTypesPath, trainingsPath};
        
        for (String path : paths) {
            
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                
                String line;
                boolean isFirstLine = true;
                
                while ((line = reader.readLine()) != null) {
                    if (isFirstLine) {
                        isFirstLine = false;
                        continue;
                    }
                    String[] fields = line.split(",");
                    
                    if (path.equals(trainersPath)) {
                        Trainer trainer = new Trainer(Long.parseLong(fields[0]), fields[1], fields[2], fields[3], fields[4], Boolean.parseBoolean(fields[5]), fields[6]);
                        trainerService.createTrainer(trainer);
                    } else if (path.equals(traineesPath)) {
                        Trainee trainee = new Trainee(Long.parseLong(fields[0]), fields[1], fields[2], fields[3], fields[4], Boolean.parseBoolean(fields[5]), LocalDate.parse(fields[6]), fields[7]);
                        traineeService.createTrainee(trainee);
                    } else if (path.equals(trainingTypesPath)) {
                        TrainingType trainingType = new TrainingType(Long.parseLong(fields[0]), fields[1]);
                        trainingService.createTrainingType(trainingType);
                    } else if (path.equals(trainingsPath)) {
                        Training training = new Training(Long.parseLong(fields[0]), Long.parseLong(fields[1]), Long.parseLong(fields[2]), fields[3], Long.parseLong(fields[4]), LocalDate.parse(fields[5]), Period.parse(fields[6]));
                        trainingService.createTraining(training);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public Trainer getTrainer (long trainerId) {
        return trainerService.getTrainer(trainerId);
    }
    
    public List <Trainer> getAllTrainers () {
        return trainerService.getAllTrainers();
    }
    
    
    public Trainee getTrainee (long traineeId) {
        return traineeService.getTrainee(traineeId);
    }
    
    public List <Trainee> getAllTrainees () {
        return traineeService.getAllTrainees();
    }
    
    
    public Training getTraining (long trainingId) {
        return trainingService.getTraining(trainingId);
    }
    
    public List <Training> getAllTrainings () {
        return trainingService.getAllTrainings();
    }
    
    
    public List <TrainingType> getAllTrainingTypes () {
        return trainingService.getAllTrainingTypes();
    }
    
    public void createTrainingType (TrainingType trainingType) {
        trainingService.createTrainingType(trainingType);
    }
    
    public TrainingType getTrainingType (long trainingTypeId) {
        return trainingService.getTrainingType(trainingTypeId);
    }
    
    public void createTraining (Training newTraining) {
        trainingService.createTraining(newTraining);
    }
    
    public void createTrainer (Trainer newTrainer) {
        trainerService.createTrainer(newTrainer);
    }
    
    public void createTrainee (Trainee newTrainee) {
        traineeService.createTrainee(newTrainee);
    }
    
    public void updateTrainer (Trainer updatedTrainer) {
        trainerService.updateTrainer(updatedTrainer);
    }
    
    public void updateTrainee (Trainee updatedTrainee) {
        traineeService.updateTrainee(updatedTrainee);
    }
    
    public void deleteTrainee (long deletedTraineeId) {
        traineeService.deleteTrainee(deletedTraineeId);
    }
}
