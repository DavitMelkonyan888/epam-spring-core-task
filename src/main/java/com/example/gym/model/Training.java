package com.example.gym.model;

import java.time.LocalDate;
import java.time.Period;

public class Training {
    
    private long id;
    private long trainerId;
    private long traineeId;
    private String name;
    private long trainingTypeId;
    private LocalDate date;
    private Period duration;
    
    public Training () {
    }
    
    public Training (long id, long trainerId, long traineeId, String name, long trainingTypeId, LocalDate date, Period duration) {
        this.id = id;
        this.trainerId = trainerId;
        this.traineeId = traineeId;
        this.name = name;
        this.trainingTypeId = trainingTypeId;
        this.date = date;
        this.duration = duration;
    }
    
    public long getId () {
        return id;
    }
    
    public void setId (long id) {
        this.id = id;
    }
    
    public long getTrainerId () {
        return trainerId;
    }
    
    public void setTrainerId (long trainerId) {
        this.trainerId = trainerId;
    }
    
    public long getTraineeId () {
        return traineeId;
    }
    
    public void setTraineeId (long traineeId) {
        this.traineeId = traineeId;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public long getTrainingTypeId () {
        return trainingTypeId;
    }
    
    public void setTrainingTypeId (long trainingTypeId) {
        this.trainingTypeId = trainingTypeId;
    }
    
    public LocalDate getDate () {
        return date;
    }
    
    public void setDate (LocalDate date) {
        this.date = date;
    }
    
    public Period getDuration () {
        return duration;
    }
    
    public void setDuration (Period duration) {
        this.duration = duration;
    }
}
