/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.exercise.model;

/**
 *
 * @author lkatiyar
 */
public class StockValue {

    private final String year;
    private final String month;
    private final float value;

    public StockValue(final String year, final String month, final float value) {
        this.year = year;
        this.month = month;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Stock Value is : {" + "year=" + year + ", month=" + month + ", value=" + value + '}';
    }

    public float getValue() {
        return value;
    }
}
