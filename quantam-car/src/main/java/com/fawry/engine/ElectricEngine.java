package com.fawry.engine;

public class ElectricEngine implements Engine {

    private int internalSpeed = 0;

    public void start() {
        System.out.println("Electric engine started");
    }

    public void stop() {
        System.out.println("Electric engine stopped");
        internalSpeed = 0;
    }

    public void setSpeed(int speed) {
        while (internalSpeed < speed) increase();
        while (internalSpeed > speed) decrease();
    }

    public void increase() {
        internalSpeed++;
    }

    public void decrease() {
        if (internalSpeed > 0) internalSpeed--;
    }
}

