package com.example.gym.view.impl;

import com.example.gym.facade.GymFacade;
import com.example.gym.model.*;
import com.example.gym.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class ConsoleView implements View {
    
    private GymFacade gymFacade;
    
    @Autowired
    public void setGymFacade (GymFacade gymFacade) {
        this.gymFacade = gymFacade;
    }
    
    public void start () {
        Scanner sc = new Scanner(System.in);
        int action;
        int innerAction;
        do {
            try {
                typeMainMenu();
                action = sc.nextInt();
                if (action < 1 || action > 4) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("\n!!!Invalid Input Please Try Again!!!\n");
                action = 0;
            }
            switch (action) {
                case 1 -> {
                    do {
                        try {
                            typeTrainerServiceMenu();
                            innerAction = sc.nextInt();
                            if (innerAction < 1 || innerAction > 5) {
                                throw new Exception();
                            }
                        } catch (Exception e) {
                            System.out.println("\n!!!Invalid Input Please Try Again!!!\n");
                            innerAction = 0;
                        }
                        switch (innerAction) {
                            case 1:
                                //TODO
                                break;
                            case 2:
                                //TODO
                                break;
                            case 3:
                                System.out.print("\nPlease Enter ID for Trainer --> ");
                                long trainerId = sc.nextLong();
                                Trainer trainer = gymFacade.getTrainer(trainerId);
                                if (trainer != null) {
                                    System.out.println("\n" + trainer + "\n");
                                } else {
                                    System.out.println("\n!!!No Trainer Found With That ID!!!\n");
                                }
                                break;
                            case 4:
                                System.out.println(gymFacade.getAllTrainers());
                                break;
                            default:
                                break;
                        }
                    } while (innerAction != 5);
                }
                case 2 -> {
                    do {
                        try {
                            typeTraineeServiceMenu();
                            innerAction = sc.nextInt();
                            if (innerAction < 1 || innerAction > 6) {
                                throw new Exception();
                            }
                        } catch (Exception e) {
                            System.out.println("\n!!!Invalid Input Please Try Again!!!\n");
                            innerAction = 0;
                        }
                        switch (innerAction) {
                            case 1:
                                //TODO
                                break;
                            case 2:
                                //TODO
                                break;
                            case 3:
                                //TODO
                                break;
                            case 4:
                                System.out.print("\nPlease Enter ID for Trainee --> ");
                                long traineeId = sc.nextLong();
                                Trainee trainee = gymFacade.getTrainee(traineeId);
                                if (trainee != null) {
                                    System.out.println("\n" + trainee + "\n");
                                } else {
                                    System.out.println("\n!!!No Trainee Found With That ID!!!\n");
                                }
                                break;
                            case 5:
                                System.out.println(gymFacade.getAllTrainees());
                                break;
                            default:
                                break;
                        }
                    } while (innerAction != 6);
                }
                case 3 -> {
                    do {
                        try {
                            typeTrainingServiceMenu();
                            innerAction = sc.nextInt();
                            if (innerAction < 1 || innerAction > 6) {
                                throw new Exception();
                            }
                        } catch (Exception e) {
                            System.out.println("\n!!!Invalid Input Please Try Again!!!\n");
                            innerAction = 0;
                        }
                        switch (innerAction) {
                            case 1:
                                //TODO
                                break;
                            case 2:
                                System.out.print("\nPlease Enter ID for Training --> ");
                                long trainingId = sc.nextLong();
                                Training training = gymFacade.getTraining(trainingId);
                                if (training != null) {
                                    System.out.println("\n" + training + "\n");
                                } else {
                                    System.out.println("\n!!!No Training Found With That ID!!!\n");
                                }
                                break;
                            case 3:
                                System.out.println("\n" + gymFacade.getAllTrainings() + "\n");
                                break;
                            case 4:
                                TrainingType newTrainingType = new TrainingType();
                                System.out.print("\nPlease Enter ID for New Training Type --> ");
                                newTrainingType.setId(sc.nextLong());
                                System.out.print("\nPlease Enter Name for New Training Type --> ");
                                newTrainingType.setName(sc.next());
                                gymFacade.createTrainingType(newTrainingType);
                                break;
                            case 5:
                                System.out.println("\n" + gymFacade.getAllTrainingTypes() + "\n");
                                break;
                            default:
                                break;
                        }
                    } while (innerAction != 6);
                }
                default -> {
                }
            }
        } while (action != 4);
    }
    
    public void typeMainMenu () {
        System.out.println("Main Menu");
        System.out.println("1 - Trainer Service");
        System.out.println("2 - Trainee Service");
        System.out.println("3 - Training Service");
        System.out.println("4 - Exit");
        System.out.print("Choose Your Action --> ");
    }
    
    public void typeTrainerServiceMenu () {
        System.out.println("Trainer Service Menu");
        System.out.println("1 - Create Trainer");
        System.out.println("2 - Update Trainer");
        System.out.println("3 - Get Trainer");
        System.out.println("4 - Get All Trainers");
        System.out.println("5 - Previous Menu");
        System.out.print("Choose Your Action --> ");
    }
    
    public void typeTraineeServiceMenu () {
        System.out.println("Trainee Service Menu");
        System.out.println("1 - Create Trainee");
        System.out.println("2 - Update Trainee");
        System.out.println("3 - Delete Trainee");
        System.out.println("4 - Get Trainee");
        System.out.println("5 - Get All Trainees");
        System.out.println("6 - Previous Menu");
        System.out.print("Choose Your Action --> ");
    }
    
    public void typeTrainingServiceMenu () {
        System.out.println("Training Service Menu");
        System.out.println("1 - Create Training");
        System.out.println("2 - Get Training");
        System.out.println("3 - Get All Trainings");
        System.out.println("4 - Create Training Type");
        System.out.println("5 - Get All Training Types");
        System.out.println("6 - Previous Menu");
        System.out.print("Choose Your Action --> ");
    }
}
