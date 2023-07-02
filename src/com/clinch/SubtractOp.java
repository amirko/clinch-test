package com.clinch;

public class SubtractOp extends OpExpression {
    protected SubtractOp(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double getValue() {
        return left.getValue() - right.getValue();
    }
}
