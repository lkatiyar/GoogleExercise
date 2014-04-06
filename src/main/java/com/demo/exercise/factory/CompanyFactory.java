package com.demo.exercise.factory;

import com.demo.exercise.model.Company;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lkatiyar
 */
public class CompanyFactory {

    /* **************************************** */
    // Private Static Fields
    /* **************************************** */
    /** Collection to store created Company Objects */
    private static final Map<String, Company> companies = new HashMap<>();

    /**
     * To get Company Instance.
     *
     * @param name : Company Name
     * @return : Company Object
     */
    public static Company getCompanyInstance(final String name) {

        Company company = companies.get(name);
        if (company == null) {
            company = new Company(name);
            companies.put(name, company);
        }
        return company;
    }
}
