import java.util.Comparator;

/**
 * VisitorComparator implements Comparator to sort visitors based on multiple criteria.
 * Compares visitors first by age, then by name (alphabetically).
 */
public class VisitorComparator implements Comparator<Visitor> {
    
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // First compare by age
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());
        
        if (ageComparison != 0) {
            return ageComparison;
        }
        
        // If ages are equal, compare by name alphabetically
        return v1.getName().compareTo(v2.getName());
    }
}







