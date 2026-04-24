package com.fawry.engine;


public class HybridEngine implements Engine {

    private GasEngine gasEngine = new GasEngine();
    private ElectricEngine electricEngine = new ElectricEngine();
    private Engine operatingEngine;
    private int currentSpeed = 0;

    public void start() {
        operatingEngine = electricEngine;
        electricEngine.start();
    }

    public void setSpeed(int speed) {
        if (speed >= 50 && currentSpeed < 50) {
            electricEngine.stop();
            gasEngine.start();
            operatingEngine = gasEngine;
        } else if (speed < 50 && currentSpeed >= 50) {
            gasEngine.stop();
            electricEngine.start();
            operatingEngine = electricEngine;
        }
        currentSpeed = speed;
        operatingEngine.setSpeed(speed);
    }

    public void stop() {
        operatingEngine.stop();
    }

    public void increase() {
        operatingEngine.increase();
    }

    public void decrease() {
        operatingEngine.decrease();
    }
}

