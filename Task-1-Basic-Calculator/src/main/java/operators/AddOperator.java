package operators;

import enums.OPERATOR_DIRECTION;
import interfaces.Operator;

import static enums.OPERATOR_DIRECTION.LEFT;
import static enums.PRIORITY_LEVEL.LOW;

public class AddOperator implements Operator {
    @Override
    public String getSymbol() {
        return "+";
    }

    @Override
    public int getPriority() {
        return LOW.getPriority();
    }

    @Override
    public OPERATOR_DIRECTION getDirection() {
        return LEFT;
    }

    @Override
    public double apply(double a, double b) {
        return a + b;
    }
}
