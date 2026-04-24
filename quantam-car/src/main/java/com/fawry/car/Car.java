package com.fawry.car;

import com.fawry.engine.Engine;

public class Car {
    private int speed = 0;
    private Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();
    }

    public void stop() {
        if (this.speed == 0) {
            engine.stop();
        } else {
            System.out.println("Cannot stop. Speed must be 0. Current: " + speed);
        }
    }

    public void accelerate() {
        if (this.speed < 200) {
            this.speed += 20;
            engine.setSpeed(this.speed);
        }
    }

    public void brake() {
        if (this.speed > 0) {
            this.speed -= 20;
            engine.setSpeed(this.speed);
        }
    }

    public int getSpeed() {
        return speed;
    }
}

