package com.clinch;

public class FormulaParser {

    private final Excel excel;

    public FormulaParser(Excel excel) {
        this.excel = excel;
    }

    public Expression parse(String formula) {
        Double value = excel.getValue(formula);
        if(value != null) {
            return new NumberExpression(value);
        }
        int signLocation = formula.indexOf('*');
        if(signLocation > 0) {
            Expression[] children = parseLeftRight(formula, signLocation);
            return new MultiplicationOp(children[0], children[1]);
        }
        signLocation = formula.indexOf("/");
        if(signLocation > 0) {
            Expression[] children = parseLeftRight(formula, signLocation);
            return new DivisionOp(children[0], children[1]);
        }
        signLocation = formula.indexOf('+');
        if(signLocation > 0) {
            Expression[] children = parseLeftRight(formula, signLocation);
            return new AddOp(children[0], children[1]);
        }
        signLocation = formula.indexOf('-');
        if(signLocation > 0) {
            Expression[] children = parseLeftRight(formula, signLocation);
            return new SubtractOp(children[0], children[1]);
        }
        if(formula.matches("[0-9]+")) { // check for number
            return new NumberExpression(Double.parseDouble(formula));
        }
        String cell = excel.getExpression(formula);
        return parse(cell);
    }

    private Expression[] parseLeftRight(String formula, int location) {
        Expression left = parse(formula.substring(0, location));
        Expression right = parse(formula.substring(location + 1));
        return new Expression[]{left, right};
    }
}
