package interfaces;

import enums.OPERATOR_DIRECTION;

public interface Operator {
    String getSymbol();
    int getPriority();
    OPERATOR_DIRECTION getDirection();
    double apply(double a, double b);
}
