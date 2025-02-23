package com.example.gym.storage;

import com.example.gym.model.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

@Component
//@PropertySource(value = "classpath:/application.properties")
public class Storage
//        implements InitializingBean
{
    private TraineeStorage traineeStorage;
    private TrainerStorage trainerStorage;
    private TrainingStorage trainingStorage;
    private TrainingTypeStorage trainingTypeStorage;
    
//    @Value("${storage.path.trainings}")
//    private String trainingsPath;
//    @Value("${storage.path.trainers}")
//    private String trainersPath;
//    @Value("${storage.path.trainees}")
//    private String traineesPath;
//    @Value("${storage.path.training-types}")
//    private String trainingTypesPath;
    
    @Autowired
    public Storage (TraineeStorage traineeStorage, TrainerStorage trainerStorage, TrainingStorage trainingStorage, TrainingTypeStorage trainingTypeStorage) {
        this.traineeStorage = traineeStorage;
        this.trainerStorage = trainerStorage;
        this.trainingStorage = trainingStorage;
        this.trainingTypeStorage = trainingTypeStorage;
    }
    
    public Map <Long, Trainee> getTrainees () {
        return traineeStorage.getTrainees();
    }
    
    public Map <Long, Trainer> getTrainers () {
        return trainerStorage.getTrainers();
    }
    
    public Map <Long, Training> getTrainings () {
        return trainingStorage.getTrainings();
    }
    
    public Map <Long, TrainingType> getTrainingTypes () {
        return trainingTypeStorage.getTrainingTypes();
    }
    
//    @Override
//    public void afterPropertiesSet () {
//
//        String[] paths = {trainingsPath, trainersPath, traineesPath, trainingTypesPath};
//
//        for (String path : paths) {
//
//            try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
//
//                String line;
//                while ((line = reader.readLine()) != null) {
//
//                    String[] fields = line.split(",");
//
//                    //TODO save in storage Maps
//                    if(path.equals(trainingsPath)){
//
//                    } else if (path.equals(trainersPath)) {
//
//                    } else if (path.equals(traineesPath)) {
//
//                    } else if (path.equals(trainingTypesPath)) {
//
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
