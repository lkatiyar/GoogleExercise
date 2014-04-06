/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.exercise.controller;

import com.demo.exercise.model.Company;
import com.demo.exercise.model.StockValue;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lokesh
 */
public class DataProcessorTest {
    
    public DataProcessorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readCSV method, of class DataProcessor.
     */
    @Test
    public void testReadCSV() {
        System.out.println("readCSV");
        String csvFile = "";
        DataProcessor instance = new DataProcessor();
        List expResult = null;
        List result = instance.readCSV(csvFile);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of getHighestStockValue method, of class DataProcessor.
     */
    @Test
    public void testGetHighestStockValue() {
        System.out.println("getHighestStockValue");
        Company company = null;
        DataProcessor instance = new DataProcessor();
        StockValue expResult = null;
        StockValue result = instance.getHighestStockValue(company);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}