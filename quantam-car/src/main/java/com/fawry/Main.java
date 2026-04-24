package com.fawry;

import com.fawry.car.Car;
import com.fawry.factory.CarFactory;
import com.fawry.factory.CarFactory.EngineType;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Gas Car ===");
        Car gasCar = CarFactory.createCar(EngineType.GAS);
        gasCar.start();
        gasCar.accelerate();
        System.out.println("Speed: " + gasCar.getSpeed());
        gasCar.accelerate();
        System.out.println("Speed: " + gasCar.getSpeed());
        gasCar.brake();
        System.out.println("Speed: " + gasCar.getSpeed());
        gasCar.brake();
        System.out.println("Speed: " + gasCar.getSpeed());
        gasCar.stop();

        System.out.println("\n=== Electric Car ===");
        Car electricCar = CarFactory.createCar(EngineType.ELECTRIC);
        electricCar.start();
        electricCar.accelerate();
        electricCar.accelerate();
        electricCar.accelerate();
        System.out.println("Speed: " + electricCar.getSpeed());
        electricCar.stop(); // should fail — speed is not 0
        electricCar.brake();
        electricCar.brake();
        electricCar.brake();
        System.out.println("Speed: " + electricCar.getSpeed());
        electricCar.stop();

        System.out.println("\n=== Hybrid Car ===");
        Car hybridCar = CarFactory.createCar(EngineType.HYBRID);
        hybridCar.start();
        // Accelerate past 50 to trigger engine switch
        for (int i = 0; i < 4; i++) {
            hybridCar.accelerate();
            System.out.println("Speed: " + hybridCar.getSpeed());
        }
        // Brake back below 50 to switch back to electric
        for (int i = 0; i < 4; i++) {
            hybridCar.brake();
            System.out.println("Speed: " + hybridCar.getSpeed());
        }
        hybridCar.stop();
    }
}