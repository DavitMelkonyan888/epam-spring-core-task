package com.example.gym.model;

public class Trainer extends User {
    
    private String specialization;
    
    public Trainer () {
    }
    
    public Trainer (long id, String firstName, String lastName, String username, String password, boolean isActive, String specialization) {
        super(id, firstName, lastName, username, password, isActive);
        this.specialization = specialization;
    }
    
    public String getSpecialization () {
        return specialization;
    }
    
    public void setSpecialization (String specialization) {
        this.specialization = specialization;
    }
    
    @Override
    public String toString () {
        return "Trainer{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", username='" + username + '\'' + ", password='" + "**********" + '\'' + ", isActive=" + isActive + ", specialization='" + specialization + '\'' + "}\n";
    }
}
