package be.eekhaut.kristof.solid.srp;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String userName;
    private String firstName;
    private String lastName;
    private boolean isManager;

    private static final List<Employee> allEmployees = new ArrayList<>();       // We just store the data in memory for the example  (imagine this was done with SQL queries)

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isManager() {
        return isManager;
    }

    public static List<Employee> listAllEmployees() {
        return allEmployees;
    }

    public static Employee findByUserName(String userName) {
        return allEmployees.stream()
                .filter(employee -> employee.userName.equals(userName))
                .findFirst()
                .orElse(null);
    }

    public static void createNew(String firstName, String lastName, boolean isManager) {
        Employee employee = new Employee();
        employee.userName = (firstName.charAt(0) + lastName).toLowerCase();
        employee.firstName = firstName;
        employee.lastName = lastName;
        employee.isManager = isManager;

        allEmployees.add(employee);
    }

    public int calculateSalary() {
        return isManager ? 30000 : 1000;
    }

    public void printDetails() {
        System.out.println("Employee ID:   " + userName);
        System.out.println("  First name:  " + firstName);
        System.out.println("  Last name:   " + lastName);
        System.out.println("  Is manager:  " + isManager);
    }
}
