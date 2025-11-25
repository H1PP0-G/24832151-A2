/**
 * Employee class representing theme park staff who operate rides.
 * Extends the Person class.
 */
public class Employee extends Person {
    // Additional instance variables for Employee
    private String employeeId;
    private String position;
    
    /**
     * Default constructor
     */
    public Employee() {
        super();
        this.employeeId = "";
        this.position = "";
    }
    
    /**
     * Parameterized constructor
     * @param name The employee's name
     * @param age The employee's age
     * @param phoneNumber The employee's phone number
     * @param employeeId The employee's ID
     * @param position The employee's position
     */
    public Employee(String name, int age, String phoneNumber, String employeeId, String position) {
        super(name, age, phoneNumber);
        this.employeeId = employeeId;
        this.position = position;
    }
    
    // Getters
    public String getEmployeeId() {
        return employeeId;
    }
    
    public String getPosition() {
        return position;
    }
    
    // Setters
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    @Override
    public String toString() {
        return "Employee [Name: " + getName() + ", Age: " + getAge() + 
               ", Phone: " + getPhoneNumber() + ", ID: " + employeeId + 
               ", Position: " + position + "]";
    }
}







