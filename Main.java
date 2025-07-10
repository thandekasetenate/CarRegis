package com.cars;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Collection<Car> cars = new ArrayList<>();

        int menuOption;

        System.out.println("Welcome to the vehicle registration app!");

        do {
            System.out.println("\nPlease choose an option:");
            System.out.println("(1) Capture vehicle details");
            System.out.println("(2) View vehicle report");
            System.out.println("(3) Exit app");

            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter 1, 2, or 3:");
                input.next();
            }
            menuOption = input.nextInt();

            switch (menuOption) {
                case 1 -> {
                    Car carObj = new Car();

                    System.out.print("Enter make: ");
                    String make = input.next();

                    System.out.print("Enter model: ");
                    String model = input.next();

                    String vinNum;
                    do {
                        System.out.print("Enter VIN (17 characters): ");
                        vinNum = input.next();
                    } while (vinNum.length() != 17);

                    System.out.println("Choose plate format:");
                    System.out.println("(1) Old format (e.g. AAA555GP)");
                    System.out.println("(2) New format (e.g. AA66BB GP)");
                    int plateChoice = input.nextInt();
                    String plateNum = "";
                    if (plateChoice == 1) {
                        System.out.print("Enter plate number: ");
                        plateNum = input.next();
                    } else if (plateChoice == 2) {
                        System.out.print("Enter plate number: ");
                        plateNum = input.next();
                    }

                    System.out.print("Enter mileage: ");
                    int millage = input.nextInt();

                    System.out.print("Enter year: ");
                    int year = input.nextInt();

                    System.out.print("Enter vehicle type (e.g. Sedan, SUV): ");
                    String type = input.next();

                    System.out.print("Enter fuel type (Petrol/Diesel/Electric): ");
                    String fuelType = input.next();

                    System.out.print("Is it automatic? (true/false): ");
                    boolean isAutomatic = input.nextBoolean();

                    // Set all fields
                    carObj.setMake(make);
                    carObj.setModel(model);
                    carObj.setVin(vinNum);
                    carObj.setPlateNumber(plateNum);
                    carObj.setMillage(millage);
                    carObj.setYear(year);
                    carObj.setMake(type);
                    carObj.setMillage(fuelType);
                    carObj.setMake(isAutomatic);

                    cars.add(carObj);
                    System.out.println("Vehicle registered successfully!");
                }

                case 2 -> {
                    if (cars.isEmpty()) {
                        System.out.println("No vehicles captured yet.");
                    } else {
                        System.out.println("\n VEHICLE REPORT");
                        for (Car car : cars) {
                            System.out.println(car.toFormattedString());
                            System.out.println("MAKE:" + car.getMake() + "\nFuelType:" + car.getMillage() + car.getMake() + "\nMODEL:" + car.getModel() + "\nPLATE NUMBER: " + car.getPlateNumber() + "\nVIN NUMBER: " + car.getVin() + "\nYEAR: " + car.getYear() + "\nMILLAGE: " + car.getMillage());
                        }
                    }
                }

                case 3 -> System.out.println("Thanks for using the app. Goodbye!");

                default -> System.out.println("Invalid option. Please try again.");
            }

        } while (menuOption != 3);

        input.close();
    }
}