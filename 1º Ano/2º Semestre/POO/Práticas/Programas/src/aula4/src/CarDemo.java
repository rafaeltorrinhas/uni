package aula4.src;

import java.util.Scanner;

class Car {
    public String make;
    public String model;
    public int year;
    public int kms;

    public Car(String make, String model, int year, int kms) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.kms = kms;
    }

    public void drive(int distance) {
        this.kms += distance;
    }

}

public class CarDemo {

    static Scanner sc = new Scanner(System.in);

    static int registerCars(Car[] cars) {

        System.out.print("Insira dados do carro (marca modelo ano quilómetros): ");
        int numCars = 0;
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                break;
            }
            String[] carData = input.split(" ");
            String make = carData[0];
            String model = carData[1];
            int year = Integer.parseInt(carData[2]);
            int kms = Integer.parseInt(carData[3]);
            cars[numCars] = new Car(make, model, year, kms);
            numCars++;
        }
        return numCars;
    }

    static void registerTrips(Car[] cars, int numCars) {

        System.out.print("Registe uma viagem no formato \"carro:distância\": ");
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                break;
            }
            String[] tripData = input.split(":");
            String carName = tripData[0];
            int distance = Integer.parseInt(tripData[1]);
            for (int i = 0; i < numCars; i++) {
                if (cars[i].make.equals(carName)) {
                    cars[i].drive(distance);
                }
            }
        }
    }

    static void listCars(Car[] cars) {
        System.out.println("\nCarros registados: ");

        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                System.out.println(cars[i].make + " " + cars[i].model + ", " + cars[i].year + ", kms: " + cars[i].kms);
            }
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {

        Car[] cars = new Car[10];

        int numCars = registerCars(cars);

        if (numCars > 0) {
            listCars(cars);
            registerTrips(cars, numCars);
            listCars(cars);
        }

        sc.close();

    }
}