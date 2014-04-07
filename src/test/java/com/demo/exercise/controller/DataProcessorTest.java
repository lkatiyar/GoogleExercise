/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.exercise.controller;

import com.demo.exercise.model.Company;
import com.demo.exercise.model.StockValue;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Lokesh
 */
public class DataProcessorTest {
    
    private static DataProcessor dataProcessor;
    private List<Company> companies;
    
    ////////////////////////////////////////////
    // Test Data given in csv file.
    //==========================================
    //Year	Month	Company A Company B
    //==========================================
    //1990	Jan	5000	
    //2005	Dec	56        9000
    ///////////////////////////////////////////
    
    @BeforeClass
    public static void setUpClass() {
        dataProcessor=new DataProcessor("companyTestData.csv");
    }

    /**
     * Test of readCSV method, of class DataProcessor.
     */
    @Test
    public void testReadCSV() {
        this.companies=dataProcessor.readCSV();
        Assert.assertEquals("Total Companies", 2, this.companies.size());
    }
    
    /**
     * Test of getHighestStockValue method, of class DataProcessor.
     */
    @Test
    public void testGetHighestStockValue() {
        for (Company company : companies) {
            StockValue stockValue= dataProcessor.getHighestStockValue(company);
            if(company.getName().equals("Company A")){
                
            }
            
        }
    }

    
}