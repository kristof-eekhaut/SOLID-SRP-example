package be.eekhaut.kristof.solid.srp.usecase;

import be.eekhaut.kristof.solid.srp.EmployeeRepository;
import be.eekhaut.kristof.solid.srp.ui.StandardOutput;

import static java.util.Objects.requireNonNull;

public class ListEmployeesUseCase {

    private final EmployeeRepository employeeRepository;

    public ListEmployeesUseCase(EmployeeRepository employeeRepository) {
        this.employeeRepository = requireNonNull(employeeRepository);
    }

    public void execute() {
        employeeRepository.listAllEmployees()
                .forEach(StandardOutput::displayEmployeeDetails);
    }
}
