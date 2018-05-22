package application.service;

import java.util.ArrayList;

import application.model.Company;
import application.model.Customer;
import application.model.Employee;
import storage.Storage;

public class Service {
    /**
     * Creates a new Company.<br />
     * Requires: hours >= 0.
     */
    public static Company createCompany(String name, int hours) {
        Company company = new Company(name, hours);
        Storage.addCompany(company);
        return company;
    }

    /**
     * Deletes the company.<br />
     * Requires: The company has no employees.
     */
    public static void deleteCompany(Company company) {
        Storage.removeCompany(company);
    }

    /**
     * Updates the company.<br />
     * Requires: hours >= 0.
     */
    public static void updateCompany(Company company, String name, int hours) {
        company.setName(name);
        company.setHours(hours);
    }

    /**
     * Get all the companies
     */
    public static ArrayList<Company> getCompanies() {
        return Storage.getCompanies();
    }

    // -------------------------------------------------------------------------

    /**
     * Creates a new employee.<br />
     * Requires: wage >= 0.
     */
    public static Employee createEmployee(String name, int wage, int employmentYear) {
        Employee employee = new Employee(name, wage, employmentYear);
        Storage.addEmployee(employee);
        return employee;
    }

    /**
     * Creates a new employee.<br />
     * Requires: wage >= 0, company!=null.
     */
    public static Employee createEmployee(String name, int wage, Company company, int employmentYear) {
        Employee employee = new Employee(name, wage, employmentYear);
        company.addEmployee(employee);
        employee.setCompany(company);
        Storage.addEmployee(employee);
        return employee;
    }


    /**
     * Deletes the employee.
     */
    public static void deleteEmployee(Employee employee) {
        Company company = employee.getCompany();
        if (company != null) {
            company.removeEmployee(employee);
            employee.clearCompany();
        }
        Storage.removeEmployee(employee);
    }

    /**
     * Updates the employee.<br />
     * Requires: wage >= 0.
     */
    public static void updateEmployee(Employee employee, String name, int wage) {
        employee.setName(name);
        employee.setWage(wage);
    }

    /**
     * Get all the employees.
     */
    public static ArrayList<Employee> getEmployees() {
        return Storage.getEmployees();
    }

    // -------------------------------------------------------------------------

    /**
     * Updates the employee's company.
     */
    public static void updateCompanyOfEmployee(Employee employee, Company company) {
        Company current = employee.getCompany();
        if (current != null) {
            current.removeEmployee(employee);
            employee.clearCompany();
        }
        employee.setCompany(company);
        company.addEmployee(employee);
    }

    /**
     * Clears the company of the employee.
     */
    public static void clearCompanyOfEmployee(Employee employee) {
        Company company = employee.getCompany();
        if (company != null) {
            company.removeEmployee(employee);
            employee.clearCompany();
        }
    }

    // -------------------------------------------------------------------------
    
    public static Customer createCustomer(String name, int customerID) {
    	Customer customer = new Customer(name, customerID);
    	return customer;
    }
    
    public static void deleteCustomer(Customer customer) {
    	Storage.removeCustomer(customer);
    }
    
    public static ArrayList<Customer> getCustomers() {
    	return Storage.getCustomers();
    }
    
    public static void updateCustomer(Customer customer, String name, int customerID) {
    	customer.setName(name);
    	customer.setCustomerID(customerID);
    }
    
    public static void connectCustomerToCompany(Customer customer, Company company) {
    	System.out.println(company.getName());
    	System.out.println(customer.getName());
    	company.addCustomer(customer);
    }
    
    public static void removeCustomerFromCompany(Customer customer, Company company) {
    	company.removeCustomer(customer);
    }
    
    // -------------------------------------------------------------------------

    /**
     * Initializes the storage with some objects.
     */
    public static void initStorage() {
        Company c1 = Service.createCompany("IBM", 37);
        Company c2 = Service.createCompany("AMD", 40);
        Service.createCompany("SLED", 45);
        Service.createCompany("Vector", 32);

        Service.createEmployee("Bob Dole", 210, c2, 2001);
        Service.createEmployee("Alice Schmidt", 250, c1, 2005);
        Service.createEmployee("George Down", 150, c2, 2012);
        Service.createEmployee("Rita Uphill", 300, 1998);
        
        Service.createCustomer("Jimmy", 15);
        Service.createCustomer("Eddie", 36);
    }

}
