# Rosenbrock Optimization

This project uses the Rosenbrock function as an optimization problem to compare different algorithm variants of **Simulated Annealing (SA)** and a **(1+1) Evolutionary Algorithm (EA)**. The goal is to compare (1) the best cost found and (2) how long each approach takes.

## How to Run the Project

These instructions assume you are in the **root folder** of the repository (the same folder that contains `pom.xml`).

### Requirements
- **Java 17**
- **Maven 3.8+**

You can verify:
```bash
java --version
mvn --version

When the program runs, it prints results to the console and writes CSV output files to:
target/output/

Expected CSV files:
optimization_results_(cost_values).csv

optimization_time_(seconds).csv

## Project Structure
src/main/java/edu/stockton/Main.java — entry point (runs experiments)
src/main/java/edu/stockton/RosenbrockProblem.java — Rosenbrock optimization problem definition
src/main/java/edu/stockton/Rosenbrock.java — Rosenbrock function implementation
