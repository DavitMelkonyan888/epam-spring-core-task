package com.example.gym.utils;

import com.example.gym.model.Trainee;
import com.example.gym.model.Trainer;

import java.util.List;

public class UsernameGenerator {
    public static String generate(String firstName, String lastName, List <Trainee> existingTrainees, List <Trainer> existingTrainers) {
        String baseUsername = firstName + "." + lastName;
        long countTrainees = existingTrainees.stream().filter(t -> t.getUsername().startsWith(baseUsername)).count();
        long countTrainers = existingTrainers.stream().filter(t -> t.getUsername().startsWith(baseUsername)).count();
        long count = countTrainees + countTrainers;
        return count > 0 ? baseUsername + count : baseUsername;
    }
}
