package com.demo.exercise;

import com.demo.exercise.controller.DataProcessor;
import com.demo.exercise.model.Company;
import com.demo.exercise.model.StockValue;
import java.util.ArrayList;
import java.util.List;

/**
 * Main Launch Class.
 *
 */
public class Launch {

    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor();
        List<Company> companies = new ArrayList<>();
        if (args.length >0) {
            companies = processor.readCSV(args[0]);
        } else {
            companies = processor.readCSV( "companyData.csv");
        }

        for (Company company : companies) {
            StockValue value = processor.getHighestStockValue(company);
            System.out.println("Company : " + company.getName() + " >>>>> Highest  " + value);
        }

    }
}
