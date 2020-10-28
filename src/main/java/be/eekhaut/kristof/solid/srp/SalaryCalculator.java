package be.eekhaut.kristof.solid.srp;

public class SalaryCalculator {

    public int calculateSalary(Employee employee) {
        return employee.isManager() ? 30000 : 1000;
    }
}
