/**
 * RideInterface defines the contract for ride operations including
 * queue management, ride history, and running ride cycles.
 */
public interface RideInterface {
    /**
     * Add a visitor to the waiting queue
     * @param visitor The visitor to add to the queue
     */
    void addVisitorToQueue(Visitor visitor);
    
    /**
     * Remove a visitor from the waiting queue
     */
    void removeVisitorFromQueue();
    
    /**
     * Print all visitors currently in the waiting queue
     */
    void printQueue();
    
    /**
     * Add a visitor to the ride history
     * @param visitor The visitor to add to history
     */
    void addVisitorToHistory(Visitor visitor);
    
    /**
     * Check if a visitor exists in the ride history
     * @param visitor The visitor to check
     * @return true if visitor is in history, false otherwise
     */
    boolean checkVisitorFromHistory(Visitor visitor);
    
    /**
     * Get the number of visitors in the ride history
     * @return The number of visitors who have taken the ride
     */
    int numberOfVisitors();
    
    /**
     * Print all visitors in the ride history
     */
    void printRideHistory();
    
    /**
     * Run one cycle of the ride
     */
    void runOneCycle();
}







