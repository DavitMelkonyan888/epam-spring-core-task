package com.example.gym.utils;

import com.example.gym.model.Trainee;
import com.example.gym.model.Trainer;
import com.example.gym.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UsernameGenerator {
    
    public static String generate (String firstName, String lastName, List <Trainee> existingTrainees, List <Trainer> existingTrainers) {
        String baseUsername = firstName + "." + lastName;
        List <User> allUsers = new java.util.ArrayList <>(existingTrainees.stream().map(t -> (User) t).toList());
        allUsers.addAll(existingTrainers.stream().map(t -> (User) t).toList());
        List <User> baseList = allUsers.stream().filter(t -> t.getUsername().startsWith(baseUsername)).toList();
        if (baseList.stream().noneMatch(t -> t.getUsername().equals(baseUsername))) {
            return baseUsername;
        }
        String newUsername;
        int number = 1;
        while (true) {
            newUsername = baseUsername + number;
            String finalNewUsername = newUsername;
            if (baseList.stream().noneMatch(t -> t.getUsername().equals(finalNewUsername))){
                return newUsername;
            }
            number++;
        }
    }
}
