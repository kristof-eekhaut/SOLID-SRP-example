package be.eekhaut.kristof.solid.srp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static be.eekhaut.kristof.solid.srp.ui.StandardOutput.*;

public class MainMenu {

    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public MainMenuOption capture() throws InvalidInputException {
        MainMenuOption choice;
        do {
            displayMenu();
            choice = parseMenuOption(captureInput());
        } while (choice == null);
        return choice;
    }

    private void displayMenu() {
        blankLine();
        print("What would you like to do?");
        print("1) List all employees");
        print("2) Add a new employee");
        print("3) Calculate salary for an employee");
        print("4) Exit");
    }

    private MainMenuOption parseMenuOption(String menuChoice) {
        switch (menuChoice) {
            case "1":
                return MainMenuOption.LIST_EMPLOYEES;
            case "2":
                return MainMenuOption.ADD_NEW_EMPLOYEE;
            case "3":
                return MainMenuOption.CALCULATE_SALARY;
            case "4":
                return MainMenuOption.EXIT;

            default:
                invalidMenuChoice();
        }
        return null;
    }

    private String captureInput() {
        try {
            return input.readLine();
        } catch (IOException e) {
            throw new InvalidInputException(e);
        }
    }

    public enum MainMenuOption {
        LIST_EMPLOYEES,
        ADD_NEW_EMPLOYEE,
        CALCULATE_SALARY,
        EXIT
    }
}
