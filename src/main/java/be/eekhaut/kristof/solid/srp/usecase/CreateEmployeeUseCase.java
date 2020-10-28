package be.eekhaut.kristof.solid.srp.usecase;

import be.eekhaut.kristof.solid.srp.Employee;
import be.eekhaut.kristof.solid.srp.EmployeeRepository;
import be.eekhaut.kristof.solid.srp.NewEmployeeValidator;
import be.eekhaut.kristof.solid.srp.ui.NewEmployeeDTO;

import static be.eekhaut.kristof.solid.srp.ui.NewEmployeeForm.captureNewEmployee;
import static java.util.Objects.requireNonNull;

public class CreateEmployeeUseCase {

    private final EmployeeRepository employeeRepository;

    public CreateEmployeeUseCase(EmployeeRepository employeeRepository) {
        this.employeeRepository = requireNonNull(employeeRepository);
    }

    public void execute() {
        NewEmployeeDTO newEmployeeDTO = captureNewEmployee();
        if (NewEmployeeValidator.validate(newEmployeeDTO))
            employeeRepository.add(new Employee(newEmployeeDTO.getFirstName(), newEmployeeDTO.getLastName(), newEmployeeDTO.isManager()));
    }
}
