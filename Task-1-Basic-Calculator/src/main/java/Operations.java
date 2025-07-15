public class Operations {
    private static double result = 0;


    public static double getResult() {
        return result;
    }

    public static double process(String operation) {
        return switch (OPERATIONS.valueOf(operation.toUpperCase())) {
            case CLEAR -> {
                result = 0;
                yield result;
            }
            case RESULT -> result;
            default -> result;
        };
    }

    public static double process(String operation, double a, double b) {
        if (operation == null) {
            return 0;
        }

        return switch (OPERATIONS.valueOf(operation.toUpperCase())) {
            case SUM -> {
                result = a + b;
                yield result;
            }
            case SUB -> {
                result = a - b;
                yield result;
            }
            case MUL -> {
                result = a * b;
                yield result;
            }
            case DIV -> {
                if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                result = a / b;
                yield result;
            }
            default -> result;
        };
    }

    public static double process(String operation, double a) {
        return switch (OPERATIONS.valueOf(operation.toUpperCase())) {
            case SUM -> {
                result += a;
                yield result;
            }
            case SUB -> {
                result -= a;
                yield result;
            }
            case MUL -> {
                result *= a;
                yield result;
            }
            case DIV -> {
                if (a == 0) throw new ArithmeticException("Cannot divide by zero");
                result /= a;
                yield result;
            }
            default -> result;
        };
    }
}