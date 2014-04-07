package com.demo.exercise;

import com.demo.exercise.controller.DataProcessor;
import com.demo.exercise.model.Company;
import com.demo.exercise.model.StockValue;
import java.util.List;

/**
 * Main Launch Class.
 * 
 */
public class Launch {

	/**
	 * main method.
	 * 
	 * @param args
	 *            : command line arguments
	 */
	public static void main(String[] args) {
		DataProcessor processor = new DataProcessor("companyData.csv");
		List<Company> companies;
		// Input data taken from resources folder
		companies = processor.readCSV();
		for (Company company : companies) {
			StockValue value = processor.getHighestStockValue(company);
			System.out.println(company.getName() + " >>>>> Highest " + value);
		}

	}
}
