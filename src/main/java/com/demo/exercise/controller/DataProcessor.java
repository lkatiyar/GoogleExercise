package com.demo.exercise.controller;

import com.demo.exercise.factory.CompanyFactory;
import com.demo.exercise.model.Company;
import com.demo.exercise.model.StockValue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * The Data Processor class to store data from csv file and retrieve the 
 * highest stock Value.
 */
public class DataProcessor {

	/**
	 * Method to store data.
	 * 
	 * @param name
	 *            : Company Name
	 * @param stockValue
	 *            : stock value object
	 * @return : Company Object
	 */
	private Company storeData(final String name,
			final StockValue stockValue) {
		Company company = CompanyFactory.getCompanyInstance(name);
		company.getStock().add(stockValue);
		return company;
	}

	/**
	 * To get Highest Stock Value for Company.
	 * 
	 * @param company
	 *            : Company
	 * @return Highest stock value for given company.
	 */
	public final StockValue getHighestStockValue(final Company company) {
		List<StockValue> stockValues = new ArrayList<>(company.getStock());
		Collections.sort(stockValues, new StockComparator());
		return stockValues.get(0);
	}

	/**
         * To read given csv file and store it.
         * @param csvFile
         * @return collection of companies with their stock data
         */
	public final List<Company> readCSV(final String csvFile) {
		          BufferedReader br = null;
            String line = "";
            final String cvsSplitBy = ",";
            try {
                br = new BufferedReader(new FileReader(csvFile));
                final String headerLine = br.readLine();
                // using comma as separator
                final String[] headers = headerLine.split(cvsSplitBy);
                while ((line = br.readLine()) != null) {
                    String[] stockValues = line.split(cvsSplitBy);
                    for (int i = 2; i < headers.length; i++) {
                        String companyName = headers[i];
                        String year=stockValues[0];
                        String month=stockValues[1];
                        float value=Float.parseFloat(stockValues[i]);
                        storeData(companyName, new StockValue(year, month, value));
                    }
                }

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
		return null;
	}
}
