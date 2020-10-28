package be.eekhaut.kristof.solid.srp.usecase;

import be.eekhaut.kristof.solid.srp.Employee;
import be.eekhaut.kristof.solid.srp.EmployeeRepository;
import be.eekhaut.kristof.solid.srp.SalaryCalculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static be.eekhaut.kristof.solid.srp.ui.StandardOutput.*;
import static java.util.Objects.requireNonNull;

public class CalculateSalaryUseCase {

    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static final SalaryCalculator salaryCalculator = new SalaryCalculator();

    private final EmployeeRepository employeeRepository;

    public CalculateSalaryUseCase(EmployeeRepository employeeRepository) {
        this.employeeRepository = requireNonNull(employeeRepository);
    }

    public void execute() throws Exception {
        askUserName();
        String userName = input.readLine();
        Employee employee = employeeRepository.findByUserName(userName);

        if (employee == null) {
            couldNotFindUserName(userName);
            return;
        }

        displaySalary(salaryCalculator.calculateSalary(employee));
    }
}
