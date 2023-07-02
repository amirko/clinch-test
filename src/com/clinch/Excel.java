package com.clinch;

import java.util.HashMap;
import java.util.Map;

public class Excel {

    private Map<String, Cell> cellMap = new HashMap<>();
    private Map<String, Double> valueMap = new HashMap<>(); // had a dilemma here, maybe should have a Cell class inheritance?

    public void set(String coordinate, String formula) {
        Cell formulaCell = new Cell(formula);
        cellMap.put(coordinate, formulaCell);
    }

    public void set(String coordinate, double value) {
        Cell cell = new Cell(String.valueOf(value));
        cellMap.put(coordinate, cell);
        valueMap.put(coordinate, value);
    }

    public String getExpression(String coordinate) {
        Cell cell = cellMap.get(coordinate);
        if(cell == null) {
            return null;
        }
        return cell.getExpression();
    }

    public Double getValue(String coordinate) {
        return valueMap.get(coordinate);
    }
}
