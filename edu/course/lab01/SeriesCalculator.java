package edu.course.lab01;

public class SeriesCalculator {
    public static void run() {
        double sum = 0.0;
        int n = 2;
        int count = 0;
        double epsilon = 1e-6; // 10^-6

        while (true) {
            // Denominator: n^2 + n - 2
            double denominator = (double) n * n + n - 2;
            double term = 1.0 / denominator;

            // Stop before adding the term if its absolute value is less than 10^-6
            if (Math.abs(term) < epsilon) {
                break;
            }

            sum += term;
            count++;
            n++;
        }

        // The last added index is (n - 1) due to n++ at the end of the loop
        int lastN = n - 1;

        System.out.println("Calculated sum: " + sum);
        System.out.println("Last added index n: " + lastN);
        System.out.println("Number of added terms: " + count);
    }
}
