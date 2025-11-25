package edu.stockton;

import java.util.Arrays;

import org.cicirello.search.SolutionCostPair;
import org.cicirello.search.representations.RealVector;

import org.cicirello.search.operators.reals.RealVectorInitializer;
import org.cicirello.search.operators.reals.UndoableGaussianMutation;
import org.cicirello.search.operators.reals.UndoableCauchyMutation;
import org.cicirello.search.operators.reals.UndoableUniformMutation;
import org.cicirello.search.sa.SimulatedAnnealing;
import org.cicirello.search.sa.ExponentialCooling;
import org.cicirello.search.sa.LinearCooling;
import org.cicirello.search.sa.LogarithmicCooling;
import org.cicirello.search.evo.OnePlusOneEvolutionaryAlgorithm;

public class Main {

    public static void main(String[] args) {

        final int dimension = 2;
        final double lower = -5.0;
        final double upper = 5.0;
        final int maxEvals = 100_000;

        RosenbrockProblem problem = new RosenbrockProblem();
        RealVectorInitializer initializer =
                new RealVectorInitializer(dimension, lower, upper);
        ExponentialCooling expCooling =
                new ExponentialCooling(1000.0, 0.98);
        LinearCooling linearCooling =
                new LinearCooling(1000.0, 0.1);          
        LogarithmicCooling logCooling =
                new LogarithmicCooling(1000.0);

        //
        // Simulated Annealing
        //
        System.out.println("=== Simulated Annealing Results ===\n");

        // === Gaussian Mutation Test + Exponential Cooling ===
        UndoableGaussianMutation<RealVector> gaussian =
                UndoableGaussianMutation.createGaussianMutation(0.1);

        SimulatedAnnealing<RealVector> saGaussian =
                new SimulatedAnnealing<>(problem, gaussian, initializer, expCooling);

        SolutionCostPair<RealVector> gResult =
                saGaussian.optimize(maxEvals);

        System.out.println("Gaussian + Exponential Cooling");
        System.out.println("Best Coordinates: " +
                Arrays.toString(gResult.getSolution().toArray(null)));
        System.out.println("Best Minimum: " + gResult.getCostDouble());
        System.out.println();

        // === Gaussian Mutation Test + Linear Cooling ===
        SimulatedAnnealing<RealVector> saGaussianLinear =
                new SimulatedAnnealing<>(problem, gaussian, initializer, linearCooling);

        SolutionCostPair<RealVector> gLinResult = saGaussianLinear.optimize(maxEvals);

        System.out.println("Gaussian + Linear Cooling");
        System.out.println("Best Coordinates: " +
            Arrays.toString(gLinResult.getSolution().toArray(null)));
        System.out.println("Best Minimum: " + gLinResult.getCostDouble());
        System.out.println();

        // === Gaussian Mutation Test + Logarithmic Cooling ===
        SimulatedAnnealing<RealVector> saGaussianLog =
                new SimulatedAnnealing<>(problem, gaussian, initializer, logCooling);
        SolutionCostPair<RealVector> gLogResult = saGaussianLog.optimize(maxEvals);

        System.out.println("Gaussian + Logarithmic Cooling");
        System.out.println("Best Coordinates: " +
            Arrays.toString(gLogResult.getSolution().toArray(null)));
        System.out.println("Best Minimum: " + gLogResult.getCostDouble());
        System.out.println();

        // === Cauchy Mutation Test + Exponential Cooling ===
        UndoableCauchyMutation<RealVector> cauchy =
                UndoableCauchyMutation.createCauchyMutation(0.1);

        SimulatedAnnealing<RealVector> saCauchy =
                new SimulatedAnnealing<>(problem, cauchy, initializer, expCooling);

        SolutionCostPair<RealVector> cResult =
                saCauchy.optimize(maxEvals);

        System.out.println("Cauchy + Exponential Cooling");
        System.out.println("Best Coordinates: " +
                Arrays.toString(cResult.getSolution().toArray(null)));
        System.out.println("Best Minimum: " + cResult.getCostDouble());
        System.out.println();

        // === Cauchy Mutation Test + Linear Cooling ===
        SimulatedAnnealing<RealVector> saCauchyLinear =
                new SimulatedAnnealing<>(problem, cauchy, initializer, linearCooling);

        SolutionCostPair<RealVector> cLinResult = saCauchyLinear.optimize(maxEvals);

        System.out.println("Cauchy + Linear Cooling");
        System.out.println("Best Coordinates: " +
            Arrays.toString(cLinResult.getSolution().toArray(null)));
        System.out.println("Best Minimum: " + cLinResult.getCostDouble());
        System.out.println();

        // === Cauchy Mutation Test + Logarithmic Cooling ===
        SimulatedAnnealing<RealVector> saCauchyLog =
                new SimulatedAnnealing<>(problem, cauchy, initializer, logCooling);

        SolutionCostPair<RealVector> cLogResult = saCauchyLog.optimize(maxEvals);

        System.out.println("Cauchy + Logarithmic Cooling");
        System.out.println("Best Coordinates: " +
        Arrays.toString(cLogResult.getSolution().toArray(null)));
        System.out.println("Best Minimum: " + cLogResult.getCostDouble());
        System.out.println();

        // === Uniform Mutation Test + Exponential Cooling ===
        UndoableUniformMutation<RealVector> uniform =
                UndoableUniformMutation.createUniformMutation(0.1);

        SimulatedAnnealing<RealVector> saUniform =
                new SimulatedAnnealing<>(problem, uniform, initializer, expCooling);
                
        SolutionCostPair<RealVector> uResult =
                saUniform.optimize(maxEvals);

        System.out.println("Uniform + Exponential Cooling");
        System.out.println("Best Coordinates: " +
                Arrays.toString(uResult.getSolution().toArray(null)));
        System.out.println("Best Minimum: " + uResult.getCostDouble());
        System.out.println();

        // === Uniform Mutation Test + Linear Cooling ===
        SimulatedAnnealing<RealVector> saUniformLinear =
                new SimulatedAnnealing<>(problem, uniform, initializer, linearCooling);

        SolutionCostPair<RealVector> uLinResult = saUniformLinear.optimize(maxEvals);

        System.out.println("Uniform + Linear Cooling");
        System.out.println("Best Coordinates: " +
            Arrays.toString(uLinResult.getSolution().toArray(null)));
        System.out.println("Best Minimum: " + uLinResult.getCostDouble());
        System.out.println();

        // === Uniform Mutation Test + Logarithmic Cooling ===
        SimulatedAnnealing<RealVector> saUniformLog =
                new SimulatedAnnealing<>(problem, uniform, initializer, logCooling);

        SolutionCostPair<RealVector> uLogResult = saUniformLog.optimize(maxEvals);

        System.out.println("Uniform + Logarithmic Cooling");
        System.out.println("Best Coordinates: " +
        Arrays.toString(uLogResult.getSolution().toArray(null)));
        System.out.println("Best Minimum: " + uLogResult.getCostDouble());
        System.out.println();

        //
        // 1+1 EA
        //
        System.out.println("=== 1+1 Evolutionary Algorithm Results ===");
        // === Cauchy Mutation Test ===
        OnePlusOneEvolutionaryAlgorithm<RealVector> evoAlgCauchy =
                new OnePlusOneEvolutionaryAlgorithm<>(problem, cauchy, initializer);

        SolutionCostPair<RealVector> eaCResult = evoAlgCauchy.optimize(maxEvals);
        
        System.out.println("Cauchy");
        System.out.println("Best Coordinates: " + 
            Arrays.toString(eaCResult.getSolution().toArray(null)));
        System.out.println("Best Minimum: " + eaCResult.getCostDouble());
        System.out.println();

        //
        // === Gaussian Mutation Test===
        //
        OnePlusOneEvolutionaryAlgorithm<RealVector> evoAlgGaussian =
                new OnePlusOneEvolutionaryAlgorithm<>(problem, gaussian, initializer);

        SolutionCostPair<RealVector> eaGResult = evoAlgGaussian.optimize(maxEvals);

        System.out.println("Gaussian");
        System.out.println("Best Coordinates: " +
            Arrays.toString(eaGResult.getSolution().toArray(null)));
        System.out.println("Best Minimum: " + eaGResult.getCostDouble());
        System.out.println();

        //
        // === Uniform Mutation Test ===
        //
        OnePlusOneEvolutionaryAlgorithm<RealVector> evoAlgUniform =
                new OnePlusOneEvolutionaryAlgorithm<>(problem, uniform, initializer);
        
        SolutionCostPair<RealVector> eaUResult = evoAlgUniform.optimize(maxEvals);

        System.out.println("Uniform");
        System.out.println("Best Coordinates: " +
                Arrays.toString(eaUResult.getSolution().toArray(null)));
        System.out.println("Best Minimum: " + eaUResult.getCostDouble());
        System.out.println();
                

    }
}
