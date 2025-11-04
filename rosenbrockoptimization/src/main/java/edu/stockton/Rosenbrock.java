package edu.stockton;
public class Rosenbrock {

    /**
     * Computes the Rosenbrock function value for a given vector xx.
     *
     * @param xx an array of doubles [x1, x2, ..., xd]
     * @return the computed Rosenbrock function value
     */
    public static double rosen(double[] xx) {
        int d = xx.length;
        double sum = 0.0;

        for (int i = 0; i < d - 1; i++) {
            double xi = xx[i];
            double xnext = xx[i + 1];
            double term = 100 * Math.pow(xnext - xi * xi, 2) + Math.pow(xi - 1, 2);
            sum += term;
        }

        return sum;
    }

    public static void main(String[] args) {
        // Example usage
        double[] input = {1.0, 1.0};
        double result = rosen(input);
        System.out.println("Rosenbrock result = " + result);
    }
}
