package edu.stockton;

import org.cicirello.search.SolutionCostPair;
import org.cicirello.search.evo.OnePlusOneEvolutionaryAlgorithm;
import org.cicirello.search.operators.reals.RealVectorInitializer;
import org.cicirello.search.operators.reals.UndoableCauchyMutation;
import org.cicirello.search.operators.reals.UndoableGaussianMutation;
import org.cicirello.search.operators.reals.UndoableUniformMutation;
import org.cicirello.search.representations.RealVector;
import org.cicirello.search.sa.ExponentialCooling;
import org.cicirello.search.sa.LinearCooling;
import org.cicirello.search.sa.LogarithmicCooling;
import org.cicirello.search.sa.SimulatedAnnealing;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;


public class Main {
    public static void main(String[] args) {
        // All algorithm variants (Simulated Annealing + 1+1 EA)
        String[] variants = {
            // Simulated Annealing (9)
            "SA Gaussian + Exp",
            "SA Gaussian + Linear",
            "SA Gaussian + Log",
            "SA Cauchy + Exp",
            "SA Cauchy + Linear",
            "SA Cauchy + Log",
            "SA Uniform + Exp",
            "SA Uniform + Linear",
            "SA Uniform + Log",
            // 1+1 EA (3)
            "EA Gaussian",
            "EA Cauchy",
            "EA Uniform"
        };

        double[][] resultTable = new double[variants.length][11];
        double[][] timeTable = new double[variants.length][11];

        final double lower = -5.0;
        final double upper = 5.0;
        final int maxEvals = 100000;
        final long nanoConv = 1_000_000_000;

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        long startTime, endTime;

        for (int d = 2; d < 11; d++) {
            RosenbrockProblem problem = new RosenbrockProblem();
            RealVectorInitializer initializer =
                new RealVectorInitializer(d, lower, upper);
            ExponentialCooling expCooling =
                new ExponentialCooling(1000.0, 0.98);
            LinearCooling linearCooling =
                new LinearCooling(1000.0, 0.1);
            LogarithmicCooling logCooling =
                new LogarithmicCooling(1000.0);

            //
            // Simulated Annealing
            //

            // === Gaussian Mutation Test + Exponential Cooling ===
            startTime = bean.getCurrentThreadCpuTime();

            UndoableGaussianMutation < RealVector > gaussian =
                UndoableGaussianMutation.createGaussianMutation(0.1);

            SimulatedAnnealing < RealVector > saGaussian =
                new SimulatedAnnealing < > (problem, gaussian, initializer, expCooling);

            SolutionCostPair < RealVector > gResult =
                saGaussian.optimize(maxEvals);

            endTime = bean.getCurrentThreadCpuTime();
            timeTable[0][d-2] = (endTime - startTime) / (double) nanoConv;

            // === Gaussian Mutation Test + Linear Cooling ===
            startTime = bean.getCurrentThreadCpuTime();
            
            SimulatedAnnealing < RealVector > saGaussianLinear =
                new SimulatedAnnealing < > (problem, gaussian, initializer, linearCooling);

            SolutionCostPair < RealVector > gLinResult = saGaussianLinear.optimize(maxEvals);

            endTime = bean.getCurrentThreadCpuTime();
            timeTable[1][d-2] = (endTime - startTime) / (double) nanoConv;

            // === Gaussian Mutation Test + Logarithmic Cooling ===
            startTime = bean.getCurrentThreadCpuTime();

            SimulatedAnnealing < RealVector > saGaussianLog =
                new SimulatedAnnealing < > (problem, gaussian, initializer, logCooling);
            SolutionCostPair < RealVector > gLogResult = saGaussianLog.optimize(maxEvals);

            endTime = bean.getCurrentThreadCpuTime();
            timeTable[2][d-2] = (endTime - startTime) / (double) nanoConv;

            // === Cauchy Mutation Test + Exponential Cooling ===
            startTime = bean.getCurrentThreadCpuTime();

            UndoableCauchyMutation < RealVector > cauchy =
                UndoableCauchyMutation.createCauchyMutation(0.1);

            SimulatedAnnealing < RealVector > saCauchy =
                new SimulatedAnnealing < > (problem, cauchy, initializer, expCooling);

            SolutionCostPair < RealVector > cResult =
                saCauchy.optimize(maxEvals);

            endTime = bean.getCurrentThreadCpuTime();
            timeTable[3][d-2] = (endTime - startTime) / (double) nanoConv;

            // === Cauchy Mutation Test + Linear Cooling ===
            startTime = bean.getCurrentThreadCpuTime();

            SimulatedAnnealing < RealVector > saCauchyLinear =
                new SimulatedAnnealing < > (problem, cauchy, initializer, linearCooling);

            SolutionCostPair < RealVector > cLinResult = saCauchyLinear.optimize(maxEvals);

            endTime = bean.getCurrentThreadCpuTime();
            timeTable[4][d-2] = (endTime - startTime) / (double) nanoConv;

            // === Cauchy Mutation Test + Logarithmic Cooling ===
            startTime = bean.getCurrentThreadCpuTime();

            SimulatedAnnealing < RealVector > saCauchyLog =
                new SimulatedAnnealing < > (problem, cauchy, initializer, logCooling);

            SolutionCostPair < RealVector > cLogResult = saCauchyLog.optimize(maxEvals);

            endTime = bean.getCurrentThreadCpuTime();
            timeTable[5][d-2] = (endTime - startTime) / (double) nanoConv;

            // === Uniform Mutation Test + Exponential Cooling ===
            startTime = bean.getCurrentThreadCpuTime();

            UndoableUniformMutation < RealVector > uniform =
                UndoableUniformMutation.createUniformMutation(0.1);

            SimulatedAnnealing < RealVector > saUniform =
                new SimulatedAnnealing < > (problem, uniform, initializer, expCooling);

            SolutionCostPair < RealVector > uResult =
                saUniform.optimize(maxEvals);

            endTime = bean.getCurrentThreadCpuTime();
            timeTable[6][d-2] = (endTime - startTime) / (double) nanoConv;

            // === Uniform Mutation Test + Linear Cooling ===
            startTime = bean.getCurrentThreadCpuTime();
            SimulatedAnnealing < RealVector > saUniformLinear =
                new SimulatedAnnealing < > (problem, uniform, initializer, linearCooling);

            SolutionCostPair < RealVector > uLinResult = saUniformLinear.optimize(maxEvals);

            endTime = bean.getCurrentThreadCpuTime();
            timeTable[7][d-2] = (endTime - startTime) / (double) nanoConv;

            // === Uniform Mutation Test + Logarithmic Cooling ===
            startTime = bean.getCurrentThreadCpuTime();

            SimulatedAnnealing < RealVector > saUniformLog =
                new SimulatedAnnealing < > (problem, uniform, initializer, logCooling);

            SolutionCostPair < RealVector > uLogResult = saUniformLog.optimize(maxEvals);

            endTime = bean.getCurrentThreadCpuTime();
            timeTable[8][d-2] = (endTime - startTime) / (double) nanoConv;

            //
            // 1+1 EA
            //

            // === Gaussian Mutation Test===
            startTime = bean.getCurrentThreadCpuTime();
            OnePlusOneEvolutionaryAlgorithm < RealVector > evoAlgGaussian =
                new OnePlusOneEvolutionaryAlgorithm < > (problem, gaussian, initializer);

            SolutionCostPair < RealVector > eaGResult = evoAlgGaussian.optimize(maxEvals);

            endTime = bean.getCurrentThreadCpuTime();
            timeTable[9][d-2] = (endTime - startTime) / (double) nanoConv;

            // === Cauchy Mutation Test ===
            startTime = bean.getCurrentThreadCpuTime();

            OnePlusOneEvolutionaryAlgorithm < RealVector > evoAlgCauchy =
                new OnePlusOneEvolutionaryAlgorithm < > (problem, cauchy, initializer);

            SolutionCostPair < RealVector > eaCResult = evoAlgCauchy.optimize(maxEvals);

            endTime = bean.getCurrentThreadCpuTime();
            timeTable[10][d-2] = (endTime - startTime) / (double) nanoConv;

            // === Uniform Mutation Test ===
            startTime = bean.getCurrentThreadCpuTime();

            OnePlusOneEvolutionaryAlgorithm < RealVector > evoAlgUniform =
                new OnePlusOneEvolutionaryAlgorithm < > (problem, uniform, initializer);

            SolutionCostPair < RealVector > eaUResult = evoAlgUniform.optimize(maxEvals);

            endTime = bean.getCurrentThreadCpuTime();
            timeTable[11][d-2] = (endTime - startTime) / (double) nanoConv;

            // === SA rows ===
            resultTable[0][d-2] = gResult.getCostDouble();
            resultTable[1][d-2] = gLinResult.getCostDouble();
            resultTable[2][d-2] = gLogResult.getCostDouble();

            resultTable[3][d-2] = cResult.getCostDouble();
            resultTable[4][d-2] = cLinResult.getCostDouble();
            resultTable[5][d-2] = cLogResult.getCostDouble();

            resultTable[6][d-2] = uResult.getCostDouble();
            resultTable[7][d-2] = uLinResult.getCostDouble();
            resultTable[8][d-2] = uLogResult.getCostDouble();

            // === EA rows ===
            resultTable[9][d-2] = eaGResult.getCostDouble();
            resultTable[10][d-2] = eaCResult.getCostDouble();
            resultTable[11][d-2] = eaUResult.getCostDouble();
        }

        printUnifiedTable(variants, resultTable, "Optimization Results (Cost Values)");
        printUnifiedTable(variants, timeTable, "Optimization Time (Seconds)");
    }

    private static void printUnifiedTable(String[] rows, double[][] table, String title) {

        final int nameWidth = 30; // variant name column
        final int colWidth = 14; // each numeric column

        // Title
        System.out.println("==================== " + title + " ====================");

        // Header
        System.out.printf("%-" + nameWidth + "s", "Variant");
        for (int d = 2; d <= 10; d++) {
            System.out.printf("%" + colWidth + "s", "Dim" + d);
        }
        System.out.println();

        // Separator
        int totalWidth = nameWidth + colWidth * 9;
        for (int i = 0; i < totalWidth; i++) System.out.print("-");
        System.out.println();

        // Rows
        for (int r = 0; r < rows.length; r++) {

            System.out.printf("%-" + nameWidth + "s", rows[r]);

            for (int c = 0; c < 9; c++) {
                double val = table[r][c];

                String out;
                double abs = Math.abs(val);

                if (val == 0.0) {
                    out = "0";
                } else if (abs < 0.01) {
                    out = String.format("%.3e", val); // scientific
                } else {
                    out = String.format("%.5f", val); // fixed decimal
                }

                // RIGHT ALIGN the final string into a fixed-width field
                System.out.printf("%" + colWidth + "s", out);
            }

            System.out.println();
        }
    }

}