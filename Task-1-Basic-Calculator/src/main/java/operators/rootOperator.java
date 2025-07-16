package operators;

import enums.OPERATOR_DIRECTION;
import interfaces.Operator;

import static enums.OPERATOR_DIRECTION.RIGHT;
import static enums.PRIORITY_LEVEL.HIGH;

public class rootOperator implements Operator {
    @Override
    public String getSymbol() {
        return "sqrt";
    }

    @Override
    public int getPriority() {
        return HIGH.getPriority();
    }

    @Override
    public OPERATOR_DIRECTION getDirection() {
        return RIGHT;
    }

    @Override
    public double apply(double a, double b) {
        if (b < 0) throw new ArithmeticException("Cannot take square root of a negative number");
        return Math.sqrt(b);
    }
}
