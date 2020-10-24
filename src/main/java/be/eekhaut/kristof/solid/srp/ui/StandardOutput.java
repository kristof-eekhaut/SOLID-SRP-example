package be.eekhaut.kristof.solid.srp.ui;

import be.eekhaut.kristof.solid.srp.Employee;

import static java.lang.String.format;

public class StandardOutput {

    public static void blankLine() {
        System.out.println();
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printError(String message) {
        System.err.println(message);
    }

    public static void printValidationError(String field) {
        printError(format("The %s was not valid", field));
    }

    public static void greetUser() {
        print("Welcome to the Employee Application!");
    }

    public static void askUserName() {
        print("What is the username of the employee?");
    }

    public static void couldNotFindUserName(String userName) {
        printError("Could not find employee with username: " + userName);
    }

    public static void invalidMenuChoice() {
        printError("Invalid choice!");
    }

    public static void displaySalary(int salary) {
        print("His salary will be: €" + salary);
    }

    public static void displayEmployeeDetails(Employee employee) {
        print("Employee ID:   " + employee.getUserName());
        print("  First name:  " + employee.getFirstName());
        print("  Last name:   " + employee.getLastName());
        print("  Is manager:  " + employee.isManager());
    }
}
