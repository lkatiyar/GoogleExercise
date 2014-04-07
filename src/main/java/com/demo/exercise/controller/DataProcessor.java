package com.demo.exercise.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.demo.exercise.factory.CompanyFactory;
import com.demo.exercise.model.Company;
import com.demo.exercise.model.StockValue;

/**
 * The Data Processor class to store data from csv file and retrieve the highest
 * stock Value.
 */
public class DataProcessor {
	/* **************************************** */
	// Private Fields
	/* **************************************** */
	/** The csv File for upload. */
	private String csvFile;

	/* **************************************** */
	// Constructors
	/* **************************************** */
	
	/**
	 * constructor for Data Processor class
	 * @param csvFile
	 *            : file used for company data
	 */
	public DataProcessor(final String file) {
		this.csvFile = file;
	}

	/**
	 * Method to store data.
	 * 
	 * @param name
	 *            : Company Name
	 * @param stockValue
	 *            : stock value object
	 * @return : Company Object
	 */
	private Company storeData(final String name, final StockValue stockValue) {
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
		return stockValues.get(stockValues.size() - 1);
	}

	/**
	 * To read given csv file and store it.
	 * @param csvFile
	 * @return collection of companies with their stock data
	 */
	public final List<Company> readCSV() {
		BufferedReader br = null;
		String line;
		final String cvsSplitBy = ",";
		Set<Company> companies = new HashSet<>();
		try {
			InputStream file = ClassLoader.getSystemResourceAsStream(csvFile);
			Reader reader = new InputStreamReader(file);
			br = new BufferedReader(reader);
			final String headerLine = br.readLine();
			// using comma as separator
			final String[] headers = headerLine.split(cvsSplitBy);
			while ((line = br.readLine()) != null) {
				String[] stockValues = line.split(cvsSplitBy);
				for (int i = 2; i < headers.length; i++) {
					String companyName = headers[i];
					String year = stockValues[0];
					String month = stockValues[1];
					Company company = null;
					if(stockValues.length-1>=i){
						//condition to check if the cell value is empty
						if(stockValues[i].isEmpty()){
							stockValues[i]="0";
						}
						float value = Float.parseFloat(stockValues[i]);
						company = storeData(companyName, new StockValue(
								year, month, value));
						// first removing the old company object from set and
						// then added updayed one.
						companies.remove(company);
						companies.add(company);
					}
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
		return new ArrayList<>(companies);
	}
}
