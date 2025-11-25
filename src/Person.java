/**
 * Abstract Person class representing a general person in the theme park system.
 * This class cannot be instantiated directly and serves as a base class for Employee and Visitor.
 */
public abstract class Person {
    // Instance variables
    private String name;
    private int age;
    private String phoneNumber;
    
    /**
     * Default constructor
     */
    public Person() {
        this.name = "";
        this.age = 0;
        this.phoneNumber = "";
    }
    
    /**
     * Parameterized constructor
     * @param name The person's name
     * @param age The person's age
     * @param phoneNumber The person's phone number
     */
    public Person(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}







