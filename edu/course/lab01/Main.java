package edu.course.lab01;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
            return;
        }

        String command = args[0].toLowerCase();

        try {
            switch (command) {
                case "fizzbuzz":
                    if (args.length != 1) {
                        System.out.println("Error: The 'fizzbuzz' command does not require extra arguments.");
                        printUsage();
                        return;
                    }
                    FizzBuzz.run();
                    break;

                case "reverse":
                    if (args.length != 2) {
                        System.out.println("Error: The 'reverse' command requires exactly 1 argument (string).");
                        printUsage();
                        return;
                    }
                    TextTasks.reverse(args[1]);
                    break;

                case "quadratic":
                    if (args.length != 4) {
                        System.out.println("Error: The 'quadratic' command requires exactly 3 arguments (a, b, c).");
                        printUsage();
                        return;
                    }
                    QuadraticEquation.solve(args[1], args[2], args[3]);
                    break;

                case "series":
                    if (args.length != 1) {
                        System.out.println("Error: The 'series' command does not require extra arguments.");
                        printUsage();
                        return;
                    }
                    SeriesCalculator.run();
                    break;

                case "palindrome":
                    if (args.length != 2) {
                        System.out.println("Error: The 'palindrome' command requires exactly 1 argument (string).");
                        printUsage();
                        return;
                    }
                    TextTasks.palindrome(args[1]);
                    break;

                default:
                    System.out.println("Error: Unknown command '" + args[0] + "'");
                    printUsage();
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static void printUsage() {
        System.out.println("Usage: <command> [arguments]");
        System.out.println("Available commands:");
        System.out.println("  fizzbuzz                  - Iterates numbers from 1 to 500 with 5 and 7 multiplicity replacement");
        System.out.println("  reverse \"<string>\"        - Reverses the string using charAt()");
        System.out.println("  quadratic <a> <b> <c>     - Solves a quadratic equation");
        System.out.println("  series                    - Calculates the infinite series sum with 10^-6 precision");
        System.out.println("  palindrome \"<string>\"     - Checks if the string is a palindrome using two pointers");
    }
}
