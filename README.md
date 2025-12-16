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

### Running the Program

The program is executed from **Main.java**
run Main.java

When Main.java runs, it prints results to the console and writes CSV output files to:
target/output/
The generated files include:

optimization_results_(cost_values).csv

optimization_time_(seconds).csv

### Project Structure
Main.java – entry point that runs all optimization experiments
RosenbrockProblem.java – defines the Rosenbrock optimization problem
Rosenbrock.java – implements the Rosenbrock function
