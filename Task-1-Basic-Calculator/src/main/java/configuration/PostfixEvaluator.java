package configuration;

import interfaces.Operator;
import registery.OperatorRegistry;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class PostfixEvaluator {
    public static double evaluate(List<String> tokens) {
        Deque<Double> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else if (OperatorRegistry.isOperator(token)) {
                Operator op = OperatorRegistry.get(token);
                double b = stack.pop();
                if (token.equals("sqrt")) {
                    stack.push(op.apply(0, b));
                } else {
                    double a = stack.pop();
                    stack.push(op.apply(a, b));
                }
            } else {
                throw new IllegalArgumentException("Invalid token in postfix: " + token);
            }
        }

        return stack.pop();
    }
}
