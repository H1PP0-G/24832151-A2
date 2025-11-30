[README.md](https://github.com/user-attachments/files/23838064/README.md)
# Park Rides Visitor Management System (PRVMS)

## Project Information
- **Course**: PROG2004 Object Oriented Programming
- **Assessment**: Assessment 2 (Portfolio)
- **Student ID**: 24832151
- **Due Date**: 1 December 2025

## Project Description
This project implements a comprehensive Theme Park Management System that manages rides, employees, and visitors. The system demonstrates advanced object-oriented programming concepts including inheritance, interfaces, abstract classes, collections, and file I/O operations.

## Features

### Part 1: Classes and Inheritance
- **Person** (Abstract Class): Base class with common attributes (name, age, phone number)
- **Employee**: Extends Person, represents ride operators
- **Visitor**: Extends Person, represents theme park visitors
- **Ride**: Manages ride information and operations

### Part 2: Abstract Class and Interface
- Person class is abstract to prevent direct instantiation
- RideInterface defines contract for ride operations
- All interface methods properly implemented in Ride class

### Part 3: Waiting Line Management (Queue)
- Implements Queue collection for FIFO visitor management
- Methods: addVisitorToQueue, removeVisitorFromQueue, printQueue
- Demonstrates proper queue operations

### Part 4A: Ride History (LinkedList)
- Uses LinkedList to store visitors who have taken rides
- Iterator implementation for traversing history
- Methods: addVisitorToHistory, checkVisitorFromHistory, numberOfVisitors, printRideHistory

### Part 4B: Sorting (Comparator)
- VisitorComparator implements Comparator interface
- Sorts by age (primary) and name (secondary)
- Uses Collections.sort() method

### Part 5: Ride Cycle Operations
- runOneCycle() method manages ride operations
- Validates operator assignment and queue status
- Transfers visitors from queue to history
- Tracks number of cycles run

### Part 6: File Export (Writing)
- exportRideHistory() writes visitor data to CSV file
- Proper exception handling
- Data persistence for backup

### Part 7: File Import (Reading)
- importRideHistory() reads visitor data from CSV file
- Reconstructs Visitor objects from file
- Exception handling for file operations

## Project Structure
```
24832151-A2/
├── src/
│   ├── Person.java              # Abstract base class
│   ├── Employee.java            # Theme park staff
│   ├── Visitor.java             # Theme park visitors
│   ├── RideInterface.java       # Interface defining ride operations
│   ├── Ride.java                # Main ride class with all functionality
│   ├── VisitorComparator.java   # Comparator for sorting visitors
│   ├── AssignmentTwo.java       # Main class with demonstrations
│   └── ride_history.csv         # Generated data file
└── README.md                    # This file
```

## Compilation and Execution

### Compile the Project
```bash
cd src
javac Person.java Employee.java Visitor.java RideInterface.java VisitorComparator.java Ride.java AssignmentTwo.java
```

### Run the Project
```bash
java AssignmentTwo
```

## Key Object-Oriented Concepts Demonstrated

### 1. Inheritance
- Employee and Visitor inherit from abstract Person class
- Code reuse and logical hierarchy
- Super constructor calls

### 2. Abstraction
- Abstract Person class cannot be instantiated
- Forces creation of specific types (Employee, Visitor)

### 3. Interfaces
- RideInterface defines contract for ride operations
- Ensures consistent implementation
- Promotes loose coupling

### 4. Encapsulation
- All instance variables are private
- Public getters and setters for controlled access
- Data hiding principle

### 5. Polymorphism
- toString() method overriding
- Interface implementation

## Collection Classes Used

### Queue (LinkedList implementation)
- **Purpose**: Manage waiting visitors in FIFO order
- **Why Queue?**: Natural fit for waiting line scenarios
- **Operations**: offer(), poll(), isEmpty()

### LinkedList
- **Purpose**: Store ride history with efficient insertion
- **Why LinkedList?**: Better than Array for dynamic sizing and insertion
- **Operations**: add(), Iterator traversal

### Comparator
- **Purpose**: Custom sorting logic
- **Implementation**: Multi-criteria sorting (age, then name)

## File I/O Operations

### CSV Format
Data is stored in comma-separated values format:
```
name,age,phoneNumber,ticketType,visitDate
```

### Exception Handling
- IOException for file operations
- NumberFormatException for data parsing
- User-friendly error messages

## Testing
All parts have been tested with comprehensive demonstrations:
- Part 3: 5+ visitors in queue operations
- Part 4A: 5+ visitors in history with Iterator
- Part 4B: 5+ visitors sorted by comparator
- Part 5: 10+ visitors with cycle operations
- Part 6: Export 5+ visitors to file
- Part 7: Import and verify data integrity

## Design Decisions

### Why Abstract Person Class?
- Person is too generic to be instantiated directly
- Forces developers to use specific types (Employee/Visitor)
- Provides common functionality through inheritance

### Why Interface vs Abstract Class for RideInterface?
- Defines behavior contract without implementation
- Allows flexibility for different ride types
- Follows "program to interface" principle
- More flexible than abstract class (can implement multiple interfaces)

### Why Queue for Waiting Line?
- FIFO matches real-world waiting line behavior
- Efficient enqueue/dequeue operations
- Clear semantic meaning

### Why LinkedList for History?
- Dynamic size (no predetermined capacity)
- Efficient insertions at the end
- Supports Iterator for traversal
- Better than Array for frequent additions

## Future Enhancements
- Multiple ride operators per ride
- Different ticket types with priority queuing
- Ride capacity validation
- Enhanced visitor statistics
- Database integration

## Academic Integrity Declaration
I acknowledge that I have not knowingly used GenAI to complete this assessment.

## Author
Student ID: 24832151
Course: PROG2004 Object Oriented Programming
Institution: Southern Cross University





