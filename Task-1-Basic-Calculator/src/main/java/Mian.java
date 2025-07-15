import java.util.Scanner;

public class Mian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Advanced Calculator");
        System.out.println("Available operations: SUM, SUB, MUL, DIV, CLEAR, RESULT");
        System.out.println("Usage:");
        System.out.println("  Single argument: OPERATION NUMBER (applies to current result)");
        System.out.println("  Two arguments: OPERATION NUMBER1 NUMBER2");
        System.out.println("  Special: CLEAR, RESULT");
        System.out.println("Enter 'exit' or 'quit' or 'q' or 'close' to quit");

        while (true) {
            System.out.println("\nCurrent result: " + Operations.getResult());
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("close")
                    || input.equalsIgnoreCase("exit")
                    || input.equalsIgnoreCase("quit")
                    || input.equalsIgnoreCase("q")) {
                break;
            }

            try {
                String[] parts = input.split(" ");
                String operation = parts[0].toUpperCase();

                if (operation.equals("CLEAR")) {
                    System.out.println("Result cleared: " + Operations.process("CLEAR"));
                } else if (operation.equals("RESULT")) {
                    System.out.println("Current result: " + Operations.process("RESULT"));
                } else if (parts.length == 2) {
                    double a = Double.parseDouble(parts[1]);
                    System.out.println("New result: " + Operations.process(operation, a));
                } else if (parts.length == 3) {
                    double a = Double.parseDouble(parts[1]);
                    double b = Double.parseDouble(parts[2]);
                    System.out.println("Result: " + Operations.process(operation, a, b));
                } else {
                    System.out.println("Invalid command format!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid operation! Available: SUM, SUB, MUL, DIV, CLEAR, RESULT");
            } catch (ArithmeticException e) {
                System.out.println("Math error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input! Format: OPERATION [NUMBER] [NUMBER]");
            }
        }

        scanner.close();
        System.out.println("Calculator closed. Final result: " + Operations.getResult());
    }
}
