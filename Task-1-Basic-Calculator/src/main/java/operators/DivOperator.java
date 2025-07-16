package operators;

import enums.OPERATOR_DIRECTION;
import interfaces.Operator;

import static enums.OPERATOR_DIRECTION.LEFT;
import static enums.PRIORITY_LEVEL.MEDIUM;

public class DivOperator implements Operator {
    @Override
    public String getSymbol() {
        return "/";
    }

    @Override
    public int getPriority() {
        return MEDIUM.getPriority();
    }

    @Override
    public OPERATOR_DIRECTION getDirection() {
        return LEFT;
    }

    @Override
    public double apply(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a/b;
    }
}
