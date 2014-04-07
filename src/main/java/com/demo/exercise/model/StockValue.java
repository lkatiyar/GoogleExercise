/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.exercise.model;

/**
 * The Stock Value Class.
 * @author lkatiyar
 */
public class StockValue {
    /* **************************************** */
    // Private Fields
    /* **************************************** */
    /** The year value. */
    private final String year;
    /** The month value. */
    private final String month;
    /** The stock value. */
    private final float value;

    
    /* **************************************** */
    // Constructors
    /* **************************************** */
    /**
     * Constructor for Stock Value.
     * @param year : year value
     * @param month : month value
     * @param value : stock value
     */
    public StockValue(final String year, final String month, final float value) {
        this.year = year;
        this.month = month;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Stock Value is : {" + "year=" + year + ", month=" + month + ", value=" + value + '}';
    }

    /**
     * to get the value of stock.
     * @return : value
     */
    public float getValue() {
        return value;
    }
}
