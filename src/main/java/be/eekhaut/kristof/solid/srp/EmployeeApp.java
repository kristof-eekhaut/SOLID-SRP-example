package be.eekhaut.kristof.solid.srp;

import be.eekhaut.kristof.solid.srp.ui.MainMenu;
import be.eekhaut.kristof.solid.srp.usecase.CalculateSalaryUseCase;
import be.eekhaut.kristof.solid.srp.usecase.CreateEmployeeUseCase;
import be.eekhaut.kristof.solid.srp.usecase.ListEmployeesUseCase;

import static be.eekhaut.kristof.solid.srp.ui.StandardOutput.greetUser;

public class EmployeeApp {

    private static final MainMenu mainMenu = new MainMenu();
    private static final EmployeeRepository employeeRepository = new EmployeeRepository();

    private static final ListEmployeesUseCase listEmployeesUseCase = new ListEmployeesUseCase(employeeRepository);
    private static final CreateEmployeeUseCase createEmployeeUseCase = new CreateEmployeeUseCase(employeeRepository);
    private static final CalculateSalaryUseCase calculateSalaryUseCase = new CalculateSalaryUseCase(employeeRepository);

    public static void main(String[] args) throws Exception {

        greetUser();

        MainMenu.MainMenuOption menuChoice;
        do {
            menuChoice = mainMenu.capture();

            switch (menuChoice) {
                case LIST_EMPLOYEES:
                    listEmployeesUseCase.execute();
                    break;

                case ADD_NEW_EMPLOYEE:
                    createEmployeeUseCase.execute();
                    break;

                case CALCULATE_SALARY:
                    calculateSalaryUseCase.execute();
                    break;

                default:
            }
        } while (!menuChoice.equals(MainMenu.MainMenuOption.EXIT));
    }
}
