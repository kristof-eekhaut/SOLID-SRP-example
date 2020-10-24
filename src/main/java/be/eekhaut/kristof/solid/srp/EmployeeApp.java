package be.eekhaut.kristof.solid.srp;

import be.eekhaut.kristof.solid.srp.ui.MainMenu;
import be.eekhaut.kristof.solid.srp.ui.NewEmployeeDTO;
import be.eekhaut.kristof.solid.srp.ui.StandardOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static be.eekhaut.kristof.solid.srp.ui.NewEmployeeForm.captureNewEmployee;
import static be.eekhaut.kristof.solid.srp.ui.StandardOutput.*;

public class EmployeeApp {

    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    private static final MainMenu mainMenu = new MainMenu();

    public static void main(String[] args) throws Exception {

        greetUser();

        MainMenu.MainMenuOption menuChoice;
        do {

            menuChoice = mainMenu.capture();

            switch (menuChoice) {
                case LIST_EMPLOYEES:
                    Employee.listAllEmployees()
                            .forEach(StandardOutput::displayEmployeeDetails);
                    break;

                case ADD_NEW_EMPLOYEE:
                    NewEmployeeDTO newEmployeeDTO = captureNewEmployee();

                    if (newEmployeeDTO.getFirstName() == null || newEmployeeDTO.getFirstName().isEmpty()) {
                        printValidationError("first name");
                        break;
                    }

                    if (newEmployeeDTO.getLastName() == null || newEmployeeDTO.getLastName().isEmpty()) {
                        printValidationError("last name");
                        break;
                    }

                    Employee.createNew(newEmployeeDTO.getFirstName(), newEmployeeDTO.getLastName(), newEmployeeDTO.isManager());
                    break;

                case CALCULATE_SALARY:
                    askUserName();
                    String userName = input.readLine();
                    Employee employee = Employee.findByUserName(userName);

                    if (employee == null) {
                        couldNotFindUserName(userName);
                        break;
                    }

                    displaySalary(employee.calculateSalary());
                    break;

                default:
            }
        } while (!menuChoice.equals(MainMenu.MainMenuOption.EXIT));
    }
}
