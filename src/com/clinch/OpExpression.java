package com.clinch;

public abstract class OpExpression implements Expression {

    protected final Expression right;
    protected final Expression left;


    protected OpExpression(Expression left, Expression right) {
        this.right = right;
        this.left = left;
    }
}
