import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * Ride class representing a theme park ride.
 * Implements RideInterface for managing visitors and ride operations.
 */
public class Ride implements RideInterface {
    // Instance variables
    private String rideName;
    private int capacity;
    private Employee rideOperator;
    private int maxRider;
    private int numOfCycles;
    
    // Collections for managing visitors
    private Queue<Visitor> waitingLine;
    private LinkedList<Visitor> rideHistory;
    
    /**
     * Default constructor
     */
    public Ride() {
        this.rideName = "";
        this.capacity = 0;
        this.rideOperator = null;
        this.maxRider = 1;
        this.numOfCycles = 0;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }
    
    /**
     * Parameterized constructor
     * @param rideName The name of the ride
     * @param capacity The maximum capacity of the ride
     * @param rideOperator The employee operating the ride
     */
    public Ride(String rideName, int capacity, Employee rideOperator) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.rideOperator = rideOperator;
        this.maxRider = capacity;
        this.numOfCycles = 0;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }
    
    // Getters
    public String getRideName() {
        return rideName;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public Employee getRideOperator() {
        return rideOperator;
    }
    
    public int getMaxRider() {
        return maxRider;
    }
    
    public int getNumOfCycles() {
        return numOfCycles;
    }
    
    // Setters
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public void setRideOperator(Employee rideOperator) {
        this.rideOperator = rideOperator;
    }
    
    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }
    
    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }
    
    // Part 3: Queue management methods
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        waitingLine.offer(visitor);
        System.out.println("SUCCESS: " + visitor.getName() + " has been added to the waiting line.");
    }
    
    @Override
    public void removeVisitorFromQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("FAILURE: The waiting line is empty. No visitor to remove.");
        } else {
            Visitor removed = waitingLine.poll();
            System.out.println("SUCCESS: " + removed.getName() + " has been removed from the waiting line.");
        }
    }
    
    @Override
    public void printQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("The waiting line is empty.");
        } else {
            System.out.println("\n===== Waiting Line for " + rideName + " =====");
            int position = 1;
            for (Visitor visitor : waitingLine) {
                System.out.println("Position " + position + ": " + visitor);
                position++;
            }
            System.out.println("Total visitors in queue: " + waitingLine.size());
            System.out.println("==========================================\n");
        }
    }
    
    // Part 4A: Ride history methods
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println("SUCCESS: " + visitor.getName() + " has been added to the ride history.");
    }
    
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean found = false;
        for (Visitor v : rideHistory) {
            if (v.getName().equals(visitor.getName()) && 
                v.getPhoneNumber().equals(visitor.getPhoneNumber())) {
                found = true;
                break;
            }
        }
        
        if (found) {
            System.out.println(visitor.getName() + " is in the ride history.");
        } else {
            System.out.println(visitor.getName() + " is NOT in the ride history.");
        }
        return found;
    }
    
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }
    
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have taken the ride yet.");
        } else {
            System.out.println("\n===== Ride History for " + rideName + " =====");
            Iterator<Visitor> iterator = rideHistory.iterator();
            int count = 1;
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                System.out.println(count + ". " + visitor);
                count++;
            }
            System.out.println("Total visitors: " + rideHistory.size());
            System.out.println("==========================================\n");
        }
    }
    
    // Part 4B: Sorting method
    public void sortRideHistory(Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator);
        System.out.println("SUCCESS: Ride history has been sorted.");
    }
    
    // Part 5: Run one cycle
    @Override
    public void runOneCycle() {
        // Check if ride operator is assigned
        if (rideOperator == null) {
            System.out.println("FAILURE: Cannot run the ride. No ride operator is assigned.");
            return;
        }
        
        // Check if there are visitors in the queue
        if (waitingLine.isEmpty()) {
            System.out.println("FAILURE: Cannot run the ride. No visitors in the waiting line.");
            return;
        }
        
        System.out.println("\n===== Running One Cycle of " + rideName + " =====");
        System.out.println("Operator: " + rideOperator.getName());
        
        int ridersThisCycle = Math.min(maxRider, waitingLine.size());
        System.out.println("Taking " + ridersThisCycle + " visitor(s) on the ride...");
        
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor visitor = waitingLine.poll();
            rideHistory.add(visitor);
            System.out.println("  - " + visitor.getName() + " is now on the ride.");
        }
        
        numOfCycles++;
        System.out.println("SUCCESS: Cycle completed! Total cycles run: " + numOfCycles);
        System.out.println("==========================================\n");
    }
    
    // Part 6: Export ride history to file
    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                // Write visitor data as CSV: name,age,phone,ticketType,visitDate
                String line = visitor.getName() + "," + 
                             visitor.getAge() + "," + 
                             visitor.getPhoneNumber() + "," + 
                             visitor.getTicketType() + "," + 
                             visitor.getVisitDate();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("SUCCESS: Ride history exported to " + filename);
        } catch (IOException e) {
            System.out.println("ERROR: Failed to export ride history. " + e.getMessage());
        }
    }
    
    // Part 7: Import ride history from file
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String phone = parts[2];
                    String ticketType = parts[3];
                    String visitDate = parts[4];
                    
                    Visitor visitor = new Visitor(name, age, phone, ticketType, visitDate);
                    rideHistory.add(visitor);
                    count++;
                }
            }
            System.out.println("SUCCESS: Imported " + count + " visitor(s) from " + filename);
        } catch (IOException e) {
            System.out.println("ERROR: Failed to import ride history. " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Invalid data format in file. " + e.getMessage());
        }
    }
}







