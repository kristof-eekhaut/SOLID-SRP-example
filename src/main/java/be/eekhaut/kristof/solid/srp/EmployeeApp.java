package be.eekhaut.kristof.solid.srp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EmployeeApp {

    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to the Employee Application!");

        String menuChoice;
        do {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1) List all employees");
            System.out.println("2) Add a new employee");
            System.out.println("3) Calculate salary for an employee");
            System.out.println("4) Exit");

            menuChoice = input.readLine();

            switch (menuChoice) {
                case "1":
                    Employee.listAllEmployees()
                            .forEach(Employee::printDetails);
                    break;

                case "2":
                    System.out.println("What is the first name?");
                    String firstName = input.readLine();
                    System.out.println("What is the last name?");
                    String lastName = input.readLine();
                    System.out.println("Is he a Manager? (yes/no)");
                    boolean isManager = input.readLine().equals("yes");

                    if (firstName == null || firstName.isEmpty()) {
                        System.out.println("The first name was not valid");
                        break;
                    }

                    if (lastName == null || lastName.isEmpty()) {
                        System.out.println("The last name was not valid");
                        break;
                    }

                    Employee.createNew(firstName, lastName, isManager);
                    break;

                case "3":
                    System.out.println("What is the username of the employee?");
                    String userName = input.readLine();
                    Employee employee = Employee.findByUserName(userName);

                    if (employee == null) {
                        System.out.println("Could not find employee with username: " + userName);
                        break;
                    }

                    System.out.println("His salary will be: €" + employee.calculateSalary());
                    break;

                case "4":
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (!menuChoice.equals("4"));
    }
}
