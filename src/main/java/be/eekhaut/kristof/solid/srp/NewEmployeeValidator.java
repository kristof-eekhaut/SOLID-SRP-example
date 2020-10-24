package be.eekhaut.kristof.solid.srp;

import be.eekhaut.kristof.solid.srp.ui.NewEmployeeDTO;

import static be.eekhaut.kristof.solid.srp.ui.StandardOutput.printValidationError;

public class NewEmployeeValidator {

    public static boolean validate(NewEmployeeDTO newEmployeeDTO) {
        if (newEmployeeDTO.getFirstName() == null || newEmployeeDTO.getFirstName().isEmpty()) {
            printValidationError("first name");
            return false;
        }

        if (newEmployeeDTO.getLastName() == null || newEmployeeDTO.getLastName().isEmpty()) {
            printValidationError("last name");
            return false;
        }
        return true;
    }
}
