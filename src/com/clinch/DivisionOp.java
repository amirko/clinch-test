package com.clinch;

public class DivisionOp extends OpExpression {
    protected DivisionOp(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double getValue() {
        return left.getValue() / right.getValue(); // check for division by zero
    }
}
