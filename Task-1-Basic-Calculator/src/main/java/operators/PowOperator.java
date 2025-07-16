package operators;

import enums.OPERATOR_DIRECTION;
import interfaces.Operator;

import static enums.OPERATOR_DIRECTION.RIGHT;
import static enums.PRIORITY_LEVEL.HIGH;

public class PowOperator implements Operator {

    @Override
    public String getSymbol() {
        return "^";
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
        return Math.pow(a, b);
    }
}
