package com.clinch;

public class AddOp extends OpExpression {
    public AddOp(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double getValue() {
        return left.getValue() + right.getValue();
    }
}
