package be.eekhaut.kristof.solid.srp;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    private final List<Employee> allEmployees = new ArrayList<>();       // We just store the data in memory for the example  (imagine this was done with SQL queries)

    public List<Employee> listAllEmployees() {
        return allEmployees;
    }

    public Employee findByUserName(String userName) {
        return allEmployees.stream()
                .filter(employee -> employee.getUserName().equals(userName))
                .findFirst()
                .orElse(null);
    }

    public void add(Employee employee) {
        allEmployees.add(employee);
    }
}
