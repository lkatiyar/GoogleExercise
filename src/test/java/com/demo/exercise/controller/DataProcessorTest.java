/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.exercise.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.demo.exercise.model.Company;
import com.demo.exercise.model.StockValue;

/**
 * Data Processor Test class.
 * This will read csv file from the src/test/resources folder.
 * @author Lokesh
 */
public class DataProcessorTest {

	private static DataProcessor dataProcessor;

	// //////////////////////////////////////////
	// Test Data given in csv file.
	// ==========================================
	// Year Month Company A Company B
	// ==========================================
	// 1990 Jan 	5000
	// 2005 Dec 				9000
	// 2013 Jul 				8999
	// /////////////////////////////////////////

	@BeforeClass
	public static void setUpClass() {
		dataProcessor = new DataProcessor("companyTestData.csv");
	}

	/**
	 * Test of readCSV method, of class DataProcessor.
	 */
	@Test
	public void testReadCSV() {
		List<Company> companies = dataProcessor.readCSV();
		Assert.assertEquals("Total Companies", 2, companies.size());
	}

	/**
	 * Test of getHighestStockValue method, of class DataProcessor.
	 */
	@Test
	public void testGetHighestStockValue() {
		List<Company> companies = dataProcessor.readCSV();
		for (Company company : companies) {
			final StockValue stockValue = dataProcessor
					.getHighestStockValue(company);
			if (company.getName().equals("Company A")) {
				Assert.assertEquals(stockValue.getValue(),
						Double.parseDouble("5000.0"), 0);
			}

			if (company.getName().equals("Company B")) {
				Assert.assertEquals(stockValue.getValue(),
						Double.parseDouble("9000.0"), 0);
			}
		}
	}
}