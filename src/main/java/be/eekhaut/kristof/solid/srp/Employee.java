package be.eekhaut.kristof.solid.srp;

public class Employee {

    private final String userName;
    private String firstName;
    private String lastName;
    private boolean isManager;

    public Employee(String firstName, String lastName, boolean isManager) {
        this.userName = (firstName.charAt(0) + lastName).toLowerCase();
        this.firstName = firstName;
        this.lastName = lastName;
        this.isManager = isManager;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isManager() {
        return isManager;
    }

    public int calculateSalary() {
        return isManager ? 30000 : 1000;
    }
}
