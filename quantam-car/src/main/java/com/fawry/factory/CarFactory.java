package com.fawry.factory;


import com.fawry.car.Car;
import com.fawry.engine.ElectricEngine;
import com.fawry.engine.Engine;
import com.fawry.engine.GasEngine;
import com.fawry.engine.HybridEngine;

public class CarFactory {

    public enum EngineType {
        GAS,
        ELECTRIC,
        HYBRID
    }

    public static Car createCar(EngineType type) {
        Car car = new Car();
        installEngine(car, type);
        return car;
    }

    private static Engine createEngine(EngineType type) {
        switch(type) {
            case GAS: return new GasEngine();
            case ELECTRIC: return new ElectricEngine();
            case HYBRID: return new HybridEngine();
            default: return null;
        }
    }

    public static void installEngine(Car car, EngineType type) {
        car.setEngine(createEngine(type));
    }
}
