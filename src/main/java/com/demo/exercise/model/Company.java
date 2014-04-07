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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
    
    
    
}
