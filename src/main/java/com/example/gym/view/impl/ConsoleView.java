package com.example.gym.view.impl;

import com.example.gym.facade.GymFacade;
import com.example.gym.model.*;
import com.example.gym.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.Period;
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
                            case 1 -> {
                                Trainer newTrainer = new Trainer();
                                System.out.print("\nPlease Enter ID for Trainer --> ");
                                newTrainer.setId(sc.nextLong());
                                if (gymFacade.getTrainer(newTrainer.getId()) != null) {
                                    System.out.println("\n!!!Trainer With That ID already exists!!!\n");
                                    break;
                                }
                                System.out.print("\nPlease Enter First Name --> ");
                                sc.nextLine();
                                newTrainer.setFirstName(sc.nextLine());
                                System.out.print("\nPlease Enter Last Name --> ");
                                newTrainer.setLastName(sc.nextLine());
                                System.out.print("\nIs Trainer Active? (true/false) --> ");
                                newTrainer.setActive(sc.nextBoolean());
                                System.out.print("\nPlease Enter Specialization --> ");
                                sc.nextLine();
                                newTrainer.setSpecialization(sc.nextLine());
                                gymFacade.createTrainer(newTrainer);
                                System.out.println("\nNew Created Trainer: " + newTrainer);
                            }
                            case 2 -> {
                                Trainer updatedTrainer = new Trainer();
                                System.out.print("\nPlease Enter ID for Trainer --> ");
                                updatedTrainer.setId(sc.nextLong());
                                if (gymFacade.getTrainer(updatedTrainer.getId()) == null) {
                                    System.out.println("\n!!!Trainer With That ID Not Found!!!\n");
                                    break;
                                }
                                System.out.print("\nPlease Enter Updated First Name --> ");
                                sc.nextLine();
                                updatedTrainer.setFirstName(sc.nextLine());
                                System.out.print("\nPlease Enter Updated Last Name --> ");
                                updatedTrainer.setLastName(sc.nextLine());
                                System.out.print("\nIs Trainer Active(Updated Value)? (true/false) --> ");
                                updatedTrainer.setActive(sc.nextBoolean());
                                System.out.print("\nPlease Enter Updated Specialization --> ");
                                sc.nextLine();
                                updatedTrainer.setSpecialization(sc.nextLine());
                                gymFacade.updateTrainer(updatedTrainer);
                                System.out.println("\nNew Updated Trainer: " + updatedTrainer);
                            }
                            case 3 -> {
                                System.out.print("\nPlease Enter ID for Trainer --> ");
                                long trainerId = sc.nextLong();
                                Trainer trainer = gymFacade.getTrainer(trainerId);
                                if (trainer != null) {
                                    System.out.println("\n" + trainer + "\n");
                                } else {
                                    System.out.println("\n!!!No Trainer Found With That ID!!!\n");
                                }
                            }
                            case 4 -> System.out.println(gymFacade.getAllTrainers());
                            default -> {
                            }
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
                            case 1 -> {
                                Trainee newTrainee = new Trainee();
                                System.out.print("\nPlease Enter ID for Trainee --> ");
                                newTrainee.setId(sc.nextLong());
                                if (gymFacade.getTrainee(newTrainee.getId()) != null) {
                                    System.out.println("\n!!!Trainee With That ID already exists!!!\n");
                                    break;
                                }
                                System.out.print("\nPlease Enter First Name --> ");
                                sc.nextLine();
                                newTrainee.setFirstName(sc.nextLine());
                                System.out.print("\nPlease Enter Last Name --> ");
                                newTrainee.setLastName(sc.nextLine());
                                System.out.print("\nIs Trainee Active? (true/false) --> ");
                                newTrainee.setActive(sc.nextBoolean());
                                System.out.print("\nPlease Enter Date of Birth (YYYY-MM-DD) --> ");
                                newTrainee.setDateOfBirth(LocalDate.parse(sc.next()));
                                System.out.print("\nPlease Enter Address --> ");
                                sc.nextLine();
                                newTrainee.setAddress(sc.nextLine());
                                gymFacade.createTrainee(newTrainee);
                                System.out.println("\nNew Created Trainee: " + newTrainee);
                            }
                            case 2 -> {
                                Trainee updatedTrainee = new Trainee();
                                System.out.print("\nPlease Enter ID for Trainee --> ");
                                updatedTrainee.setId(sc.nextLong());
                                if (gymFacade.getTrainee(updatedTrainee.getId()) == null) {
                                    System.out.println("\n!!!Trainee With That ID Not Found!!!\n");
                                    break;
                                }
                                System.out.print("\nPlease Enter Updated First Name --> ");
                                sc.nextLine();
                                updatedTrainee.setFirstName(sc.nextLine());
                                System.out.print("\nPlease Enter Updated Last Name --> ");
                                updatedTrainee.setLastName(sc.nextLine());
                                System.out.print("\nIs Trainee Active(Updated Value)? (true/false) --> ");
                                updatedTrainee.setActive(sc.nextBoolean());
                                System.out.print("\nPlease Enter Updated Date of Birth (YYYY-MM-DD) --> ");
                                updatedTrainee.setDateOfBirth(LocalDate.parse(sc.next()));
                                System.out.print("\nPlease Enter Updated Address --> ");
                                sc.nextLine();
                                updatedTrainee.setAddress(sc.nextLine());
                                gymFacade.updateTrainee(updatedTrainee);
                                System.out.println("\nNew Updated Trainee: " + updatedTrainee);
                            }
                            case 3 -> {
                                long deletedTraineeId;
                                System.out.print("\nPlease Enter ID for Trainee --> ");
                                deletedTraineeId = sc.nextLong();
                                if (gymFacade.getTrainee(deletedTraineeId) == null) {
                                    System.out.println("\n!!!Trainee With That ID Not Found!!!\n");
                                    break;
                                }
                                gymFacade.deleteTrainee(deletedTraineeId);
                                System.out.println("\n!!!Trainee Deleted Successfully!!!\n");
                            }
                            case 4 -> {
                                System.out.print("\nPlease Enter ID for Trainee --> ");
                                long traineeId = sc.nextLong();
                                Trainee trainee = gymFacade.getTrainee(traineeId);
                                if (trainee != null) {
                                    System.out.println("\n" + trainee + "\n");
                                } else {
                                    System.out.println("\n!!!No Trainee Found With That ID!!!\n");
                                }
                            }
                            case 5 -> System.out.println(gymFacade.getAllTrainees());
                            default -> {
                            }
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
                            case 1 -> {
                                Training newTraining = new Training();
                                System.out.print("\nPlease Enter ID for Training --> ");
                                newTraining.setId(sc.nextLong());
                                if (gymFacade.getTraining(newTraining.getId()) != null) {
                                    System.out.println("\n!!!Training With That ID already exists!!!\n");
                                    break;
                                }
                                System.out.print("\nPlease Enter Trainer ID --> ");
                                newTraining.setTrainerId(sc.nextLong());
                                if (gymFacade.getTrainer(newTraining.getTrainerId()) == null) {
                                    System.out.println("\n!!!No Trainer Found With That ID!!!\n");
                                    break;
                                }
                                System.out.print("\nPlease Enter Trainee ID --> ");
                                newTraining.setTraineeId(sc.nextLong());
                                if (gymFacade.getTrainee(newTraining.getTraineeId()) == null) {
                                    System.out.println("\n!!!No Trainee Found With That ID!!!\n");
                                    break;
                                }
                                System.out.print("\nPlease Enter Training Type ID --> ");
                                newTraining.setTrainingTypeId(sc.nextLong());
                                if (gymFacade.getTrainingType(newTraining.getTrainingTypeId()) == null) {
                                    System.out.println("\n!!!No Training Type Found With That ID!!!\n");
                                    break;
                                }
                                System.out.print("\nPlease Enter Training Name --> ");
                                sc.nextLine(); // Consume newline
                                newTraining.setName(sc.nextLine());
                                System.out.print("\nPlease Enter Training Date (YYYY-MM-DD) --> ");
                                newTraining.setDate(LocalDate.parse(sc.next()));
                                System.out.print("\nPlease Enter Duration (e.g., P7D for 7 days) --> ");
                                newTraining.setDuration(Period.parse(sc.next()));
                                gymFacade.createTraining(newTraining);
                                System.out.println("\nNew Created Training: " + newTraining);
                            }
                            case 2 -> {
                                System.out.print("\nPlease Enter ID for Training --> ");
                                long trainingId = sc.nextLong();
                                Training training = gymFacade.getTraining(trainingId);
                                if (training != null) {
                                    System.out.println("\n" + training + "\n");
                                } else {
                                    System.out.println("\n!!!No Training Found With That ID!!!\n");
                                }
                            }
                            case 3 -> System.out.println("\n" + gymFacade.getAllTrainings() + "\n");
                            case 4 -> {
                                TrainingType newTrainingType = new TrainingType();
                                System.out.print("\nPlease Enter ID for New Training Type --> ");
                                newTrainingType.setId(sc.nextLong());
                                if (gymFacade.getTrainingType(newTrainingType.getId()) != null) {
                                    System.out.println("\n!!!Training Type With That ID already exists!!!\n");
                                    break;
                                }
                                System.out.print("\nPlease Enter Name for New Training Type --> ");
                                sc.nextLine();
                                newTrainingType.setName(sc.nextLine());
                                gymFacade.createTrainingType(newTrainingType);
                                System.out.println("\nNew Created Training Type: " + newTrainingType);
                            }
                            case 5 -> System.out.println("\n" + gymFacade.getAllTrainingTypes() + "\n");
                            default -> {
                            }
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
