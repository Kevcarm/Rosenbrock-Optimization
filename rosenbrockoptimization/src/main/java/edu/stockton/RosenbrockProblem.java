package edu.stockton;

import org.cicirello.search.problems.OptimizationProblem;
import org.cicirello.search.representations.RealVector;

public class RosenbrockProblem implements OptimizationProblem<RealVector> {

    @Override
    public double cost(RealVector candidate) {
        double[] x = candidate.toArray(null);
        return Rosenbrock.rosen(x);
    }

    @Override
    public double value(RealVector candidate) {
        // For minimization, you could return −cost if the algorithm expects maximization,
        // but here we assume cost() is minimized so just return cost.
        return cost(candidate);
    }

    @Override
    public boolean isMinCost(double cost) {
        return cost == minCost();
    }

    @Override
    public double minCost() {
        return 0.0;  // we know global minimum cost is 0 for Rosenbrock at x = (1,1,…).
    }
}
