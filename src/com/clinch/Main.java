package com.clinch;

public class Main {

    private Excel excel = new Excel();
    private FormulaParser formulaParser = new FormulaParser(excel);

    public void set(String coordinate, String expression) {
        excel.set(coordinate, expression);
    }

    public void set(String coordinate, double value) {
        excel.set(coordinate, value);
    }

    public double get(String coordinate) {
        String formula = excel.getExpression(coordinate);
        Expression expression = formulaParser.parse(formula);
        return expression.getValue();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.set("A1", 20);
        main.set("A2", 25);
        main.set("A3", "A1+A2");
        main.set("B1", "A3*2");
        main.set("B2", "B1/2+5");
        double val = main.get("B2");
        System.out.println(val);
    }
}
