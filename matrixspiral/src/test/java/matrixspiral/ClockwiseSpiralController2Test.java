package matrixspiral;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClockwiseSpiralController2Test {

    private MovableSpy movableSpy;

    @Before
    public void setup() {
        movableSpy = new MovableSpy();
    }
    
    @Test
    public void testClockwiseSpiral1x1() {
        ClockwiseSpiralController clockwiseSpiralController = new ClockwiseSpiralController(1, 1);
        clockwiseSpiralController.setMovable(movableSpy);
        
        clockwiseSpiralController.makeMatrix();
        
        assertEquals("", movableSpy.getMovements());
    }
    
    @Test
    public void testClockwiseSpiral1x2() {
        ClockwiseSpiralController clockwiseSpiralController = new ClockwiseSpiralController(1, 2);
        clockwiseSpiralController.setMovable(movableSpy);
        
        clockwiseSpiralController.makeMatrix();
        
        assertEquals("R", movableSpy.getMovements());
    }
    
    @Test
    public void testClockwiseSpiral2x2() {
        ClockwiseSpiralController clockwiseSpiralController = new ClockwiseSpiralController(2, 2);
        clockwiseSpiralController.setMovable(movableSpy);
        
        clockwiseSpiralController.makeMatrix();
        
        assertEquals("RDL", movableSpy.getMovements());
    }
    
    @Test
    public void testClockwiseSpiral3x3() {
        ClockwiseSpiralController clockwiseSpiralController = new ClockwiseSpiralController(3, 3);
        clockwiseSpiralController.setMovable(movableSpy);
        
        clockwiseSpiralController.makeMatrix();
        
        assertEquals("RRDDLLUR", movableSpy.getMovements());
        
    }
}
