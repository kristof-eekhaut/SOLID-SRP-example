package be.eekhaut.kristof.solid.srp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static be.eekhaut.kristof.solid.srp.ui.StandardOutput.print;

public class NewEmployeeForm {

    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static NewEmployeeDTO captureNewEmployee() {
        try {
            print("What is the first name?");
            String firstName = input.readLine();
            print("What is the last name?");
            String lastName = input.readLine();
            print("Is he a Manager? (yes/no)");
            boolean isManager = input.readLine().equals("yes");

            return new NewEmployeeDTO(firstName, lastName, isManager);
        } catch (IOException e) {
            throw new InvalidInputException(e);
        }
    }
}
