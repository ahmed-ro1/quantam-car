package com.fawry.engine;


public interface Engine {
    void start();
    void stop();
    void setSpeed(int speed);
    void increase();
    void decrease();
}