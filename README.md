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
```


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



### Team Roles & Work Distribution

This project was completed collaboratively by all team members, with responsibilities intentionally divided based on strengths rather than equal commit counts. As a result, commit history alone does not fully reflect each member’s contribution.

Arsalan Saleem (ArsalanSaleem1) played a key role in the conceptual and design aspects of the project. He researched and evaluated the Chips-n-Salsa library to determine which optimization strategies, mutation operators, and representations were appropriate for the Rosenbrock optimization problem. In particular, he helped hypothesize and justify the use of Gaussian mutation and real-vector representations, identified cooling schedules necessary for simulated annealing to converge correctly, and participated in architectural decision-making during regular Discord team meetings. Arsalan also contributed to documentation updates and project setup.

Nasif Ahmed (serialUmo) focused on implementation and integration. Based on the agreed-upon design decisions, Nasif implemented and wired together the core functional components of the project, including adding and refining the Rosenbrock problem logic, ensuring the selected representations and operators worked correctly in practice, managing project structure and Maven configuration, and resolving integration issues so the system executed as intended.

Reece Cohen (ReeceC747) contributed the majority of experimental and evaluation code reflected in the commit history. This includes implementing CSV output functionality, adding and refining mutation operators (such as uniform mutation), reformatting and organizing algorithm code (e.g., 1+1 EA), adding timing benchmarks for tests, and refining experiment consistency. Reece’s work was essential for data collection, performance analysis, and empirical validation of the algorithms.

Kevin Carmona (Kevcarm) contributed significantly to documentation, reporting, and presentation of results. This included writing and expanding the project report, adding figures and methodology explanations, refining clarity and formatting, and ensuring the final written deliverables clearly communicated the experimental setup and findings.

Although Reece and Nasif have a higher number of visible commits due to implementation and experimentation tasks, all members were actively involved throughout the project lifecycle. Key algorithmic decisions, parameter choices, and methodological approaches were discussed and agreed upon collectively during frequent Discord meetings. The workload was distributed intentionally across research, design, implementation, experimentation, and documentation to ensure a cohesive and well-structured final project.
