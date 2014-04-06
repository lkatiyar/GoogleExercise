/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.exercise.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lkatiyar
 */
public class Company {
    
    private final String name;
    private List<StockValue> stock;

    public Company(String name) {
        this.name = name;
        this.stock=new ArrayList<StockValue>();
    }

    public String getName() {
        return name;
    }

    public List<StockValue> getStock() {
        return stock;
    }
    
    
}
