package registery;

import interfaces.Operator;
import operators.*;

import java.util.HashMap;
import java.util.Map;

public class OperatorRegistry  {
    private static final Map<String, Operator> operators = new HashMap<>();

    public static void register(Operator op) {
        operators.put(op.getSymbol(), op);
    }

    public static Operator get(String symbol) {
        return operators.get(symbol);
    }

    public static boolean isOperator(String token) {
        return operators.containsKey(token);
    }

    public static void loadDefaults() {
        register(new AddOperator());
        register(new SubOperator());
        register(new MulOperator());
        register(new DivOperator());
        register(new ModOperator());
        register(new PowOperator());
        register(new rootOperator());
    }
}
