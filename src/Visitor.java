/**
 * Visitor class representing theme park visitors.
 * Extends the Person class.
 */
public class Visitor extends Person {
    // Additional instance variables for Visitor
    private String ticketType;
    private String visitDate;
    
    /**
     * Default constructor
     */
    public Visitor() {
        super();
        this.ticketType = "";
        this.visitDate = "";
    }
    
    /**
     * Parameterized constructor
     * @param name The visitor's name
     * @param age The visitor's age
     * @param phoneNumber The visitor's phone number
     * @param ticketType The type of ticket (e.g., VIP, Standard)
     * @param visitDate The date of visit
     */
    public Visitor(String name, int age, String phoneNumber, String ticketType, String visitDate) {
        super(name, age, phoneNumber);
        this.ticketType = ticketType;
        this.visitDate = visitDate;
    }
    
    // Getters
    public String getTicketType() {
        return ticketType;
    }
    
    public String getVisitDate() {
        return visitDate;
    }
    
    // Setters
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    
    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }
    
    @Override
    public String toString() {
        return "Visitor [Name: " + getName() + ", Age: " + getAge() + 
               ", Phone: " + getPhoneNumber() + ", Ticket: " + ticketType + 
               ", Visit Date: " + visitDate + "]";
    }
}







