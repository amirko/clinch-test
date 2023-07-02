package com.clinch;

public class MultiplicationOp extends OpExpression {
    protected MultiplicationOp(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double getValue() {
        return left.getValue() * right.getValue();
    }
}
