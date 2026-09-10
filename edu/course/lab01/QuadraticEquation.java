package edu.course.lab01;

public class QuadraticEquation {

    public static void solve(String aStr, String bStr, String cStr) {
        double a = Double.parseDouble(aStr);
        double b = Double.parseDouble(bStr);
        double c = Double.parseDouble(cStr);

        // The equation is not quadratic if coefficient 'a' equals zero
        if (a == 0) {
            System.out.println("Error: coefficient 'a' cannot be zero.");
            return;
        }

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Two real roots: x1 = " + x1 + ", x2 = " + x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("One real root: x = " + x);
        } else {
            System.out.println("No real roots");
        }
    }
}
