package configuration;

import enums.OPERATOR_TOKEN;
import registery.OperatorRegistry;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static enums.OPERATOR_DIRECTION.LEFT;
import static enums.OPERATOR_DIRECTION.RIGHT;

public class InfixToPostfix {
    public static List<String> convert(String expression) {
        List<String> output = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();

        expression = expression.replaceAll("x", "*");
        expression = expression.replaceAll("(?<![\\d)])-(?=\\d)", "#"); // handle unary minus

        List<String> processedTokens = getTokens(expression);

        for (String token : processedTokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                output.add(token);
            } else if (OperatorRegistry.isOperator(token)) {
                while (!stack.isEmpty() && OperatorRegistry.isOperator(stack.peek())) {
                    var o1 = OperatorRegistry.get(token);
                    var o2 = OperatorRegistry.get(stack.peek());

                    boolean shouldPop =
                            (o1.getDirection() == LEFT && o1.getPriority() <= o2.getPriority()) ||
                                    (o1.getDirection() == RIGHT && o1.getPriority() < o2.getPriority());

                    if (shouldPop) output.add(stack.pop());
                    else break;
                }
                stack.push(token);
            } else if (token.equals(OPERATOR_TOKEN.LPAREN.getSymbol())) {
                stack.push(token);
            } else if (token.equals(OPERATOR_TOKEN.RPAREN.getSymbol())) {
                while (!stack.isEmpty() && !stack.peek().equals(OPERATOR_TOKEN.LPAREN.getSymbol())) {
                    output.add(stack.pop());
                }
                if (!stack.isEmpty()) stack.pop(); // pop the '('
            } else {
                throw new IllegalArgumentException("Unknown token: " + token);
            }
        }

        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }

        return output;
    }

    private static List<String> getTokens(String expression) {
        String opsRegex = OPERATOR_TOKEN.getRegexGroup(); // e.g. [+\\-*/%^()]
        String spaced = expression
                .replaceAll("(?<=" + opsRegex + ")", " ")
                .replaceAll("(?=" + opsRegex + ")", " ")
                .replaceAll("\\s+", " ")
                .trim();

        String[] tokens = spaced.split(" ");
        List<String> processedTokens = new ArrayList<>();

        for (String token : tokens) {
            if (token.startsWith("#")) {
                processedTokens.add("-" + token.substring(1)); // convert unary marker back
            } else {
                processedTokens.add(token);
            }
        }

        return processedTokens;
    }
}
