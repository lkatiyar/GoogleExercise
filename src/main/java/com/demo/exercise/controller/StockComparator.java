/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.exercise.controller;

import com.demo.exercise.model.StockValue;
import java.util.Comparator;

/**
 * Comparator class for Stock Value Sorting.
 * 
 * @author lkatiyar
 */
public class StockComparator implements Comparator<StockValue> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public final int compare(final StockValue o1, final StockValue o2) {
		return Float.compare(o1.getValue(), o2.getValue());
	}
}
