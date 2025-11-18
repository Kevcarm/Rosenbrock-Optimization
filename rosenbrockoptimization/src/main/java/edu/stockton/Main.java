package edu.stockton;

import java.util.Arrays;

import org.cicirello.search.SolutionCostPair;
import org.cicirello.search.representations.RealVector;

import org.cicirello.search.operators.reals.RealVectorInitializer;
import org.cicirello.search.operators.reals.UndoableGaussianMutation;
import org.cicirello.search.operators.reals.UndoableCauchyMutation;
import org.cicirello.search.sa.SimulatedAnnealing;
import org.cicirello.search.sa.ExponentialCooling;

public class Main {

    public static void main(String[] args) {

        final int dimension = 2;
        final double lower = -5.0;
        final double upper = 5.0;
        final int maxEvals = 100_000;

        RosenbrockProblem problem = new RosenbrockProblem();
        RealVectorInitializer initializer =
                new RealVectorInitializer(dimension, lower, upper);
        ExponentialCooling cooling =
                new ExponentialCooling(1000.0, 0.98);

        //
        // === Gaussian Mutation Test ===
        //
        UndoableGaussianMutation<RealVector> gaussian =
                UndoableGaussianMutation.createGaussianMutation(0.1);

        SimulatedAnnealing<RealVector> saGaussian =
                new SimulatedAnnealing<>(problem, gaussian, initializer, cooling);

        SolutionCostPair<RealVector> gResult =
                saGaussian.optimize(maxEvals);

        System.out.println("=== Gaussian Mutation ===");
        System.out.println("Best Coordinates: " +
                Arrays.toString(gResult.getSolution().toArray(null)));
        System.out.println("Best Minimum: " + gResult.getCostDouble());
        System.out.println();


        //
        // === Cauchy Mutation Test ===
        //
        UndoableCauchyMutation<RealVector> cauchy =
                UndoableCauchyMutation.createCauchyMutation(0.1);

        SimulatedAnnealing<RealVector> saCauchy =
                new SimulatedAnnealing<>(problem, cauchy, initializer, cooling);

        SolutionCostPair<RealVector> cResult =
                saCauchy.optimize(maxEvals);

        System.out.println("=== Cauchy Mutation ===");
        System.out.println("Best Coordinates: " +
                Arrays.toString(cResult.getSolution().toArray(null)));
        System.out.println("Best Minimum: " + cResult.getCostDouble());

    }
}
