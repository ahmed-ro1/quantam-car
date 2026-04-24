[README.md](https://github.com/user-attachments/files/27052465/README.md)
# Quantum Car

A Java demo project showcasing **OOP design patterns** including Strategy Pattern, Factory Pattern, and Polymorphism through a car engine simulation.

## Project Structure

```
src/main/java/com/fawry/
├── Main.java                  # Entry point - demos all car types
├── car/
│   └── Car.java               # Car class with speed control
├── engine/
│   ├── Engine.java            # Engine interface (Strategy)
│   ├── GasEngine.java         # Gas engine implementation
│   ├── ElectricEngine.java    # Electric engine implementation
│   └── HybridEngine.java      # Hybrid engine (switches between gas & electric)
└── factory/
    └── CarFactory.java        # Factory for creating cars with different engines
```

## Design Patterns

- **Strategy Pattern**: The `Engine` interface allows swapping engine behavior at runtime. `Car` delegates engine operations to whichever `Engine` implementation is injected.
- **Factory Pattern**: `CarFactory` encapsulates car creation logic, producing cars with the correct engine type (`GAS`, `ELECTRIC`, `HYBRID`).
- **Composition**: `HybridEngine` composes `GasEngine` and `ElectricEngine`, automatically switching between them based on speed (electric below 50, gas at 50+).

## How It Works

- **Accelerate**: Increases speed by 20 (max 200)
- **Brake**: Decreases speed by 20 (min 0)
- **Stop**: Only allowed when speed is 0
- **Hybrid switching**: At speed >= 50 the hybrid car switches from electric to gas engine, and back below 50

## Prerequisites

- Java 8+ (JDK, not JRE)
- Maven 3+

## Build & Run

```bash
mvn compile exec:java -Dexec.mainClass="com.fawry.Main"
```

## Sample Output

```
=== Gas Car ===
Gas engine started
Speed: 20
Speed: 40
Speed: 20
Speed: 0
Gas engine stopped

=== Electric Car ===
Electric engine started
Speed: 60
Cannot stop. Speed must be 0. Current: 60
Speed: 0
Electric engine stopped

=== Hybrid Car ===
Electric engine started
Speed: 20
Speed: 40
Electric engine stopped
Gas engine started
Speed: 60
Speed: 80
Speed: 60
Gas engine stopped
Electric engine started
Speed: 40
Speed: 20
Speed: 0
Electric engine stopped
```
