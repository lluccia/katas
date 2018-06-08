package problem2;

public class FibonacciCalculator {
    
    private Integer previous = 0;
    private Integer current = 0;
    private Integer next = 0;

    public Integer getNext() {
        
        if (next == 0) {
            next = 1;
        } else if (next == 1){
            next = 2;
        } else {
            next = current + previous;
        }
        
        previous = current;
        current = next;
        
        return next;
    }
    
}
