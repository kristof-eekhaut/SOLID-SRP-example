package be.eekhaut.kristof.solid.srp.ui;

public class NewEmployeeDTO {

    private final String firstName;
    private final String lastName;
    private final boolean isManager;

    public NewEmployeeDTO(String firstName,
                          String lastName,
                          boolean isManager) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isManager = isManager;
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
}
