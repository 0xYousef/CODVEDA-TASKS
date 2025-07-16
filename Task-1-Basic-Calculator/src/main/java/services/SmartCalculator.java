package services;

import configuration.InfixToPostfix;
import configuration.PostfixEvaluator;
import registery.OperatorRegistry;

import java.util.Scanner;


public class SmartCalculator {
    private static SmartCalculator instance = null;
    private double lastResult = 0;
    private final Scanner scanner;

    private SmartCalculator() {
        OperatorRegistry.loadDefaults();
        scanner = new Scanner(System.in);
    }

    public static SmartCalculator build() {
        if (instance == null) {
            instance = new SmartCalculator();
            instance.run();
        }
        return instance;
    }

    private void run() {

        printHelp();

        while (true) {
            System.out.println("\nCurrent result: " + lastResult);
            System.out.print("Enter expression: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) break;
            if (input.equalsIgnoreCase("clear")) {
                lastResult = 0;
                System.out.println("Result reset to 0.");
                continue;
            }

            try {
                input = input.replaceAll("(?i)result", Double.toString(lastResult));
                input = input.replaceAll("x", "*");

                var postfix = InfixToPostfix.convert(input);
                lastResult = PostfixEvaluator.evaluate(postfix);
                System.out.println("Result: " + lastResult);
            } catch (ArithmeticException ae) {
                System.out.println("Math error: " + ae.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid expression! " + e.getMessage());
            }
        }

        System.out.println("Calculator closed. Final result: " + lastResult);
    }

    private void printHelp() {
        System.out.println("""
                ====== Smart Stack-Based Calculator ======
                | Use: + - * / % ^ sqrt, and 'result'    |
                | Use parentheses, negative numbers, etc.|
                | Type 'clear' to reset or 'exit' to quit|
                ==========================================
                """);
    }

    public static void main(String[] args) {
        SmartCalculator.build();
    }
}
