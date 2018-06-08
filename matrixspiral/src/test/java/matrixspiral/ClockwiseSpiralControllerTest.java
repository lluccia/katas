package matrixspiral;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class ClockwiseSpiralControllerTest {

    @Test
    public void testClockwiseSpiral1x1() {
        ClockwiseSpiralController ClockwiseSpiralController = new ClockwiseSpiralController(1, 1);
        
        assertThat(ClockwiseSpiralController.makeMatrix(), is(new int[][] {
            {1}
        }));
    }
    
    @Test
    public void testClockwiseSpiral1x2() {
        ClockwiseSpiralController ClockwiseSpiralController = new ClockwiseSpiralController(1, 2);
        
        assertThat(ClockwiseSpiralController.makeMatrix(), is(new int[][] {
            {1, 2}
        }));
    }
    
    @Test
    public void testClockwiseSpiral2x2() {
        ClockwiseSpiralController ClockwiseSpiralController = new ClockwiseSpiralController(2, 2);
        
        assertThat(ClockwiseSpiralController.makeMatrix(), is(new int[][] {
            {1, 2},
            {4, 3}
        }));
    }
    
    @Test
    public void testClockwiseSpiral3x3() {
        ClockwiseSpiralController ClockwiseSpiralController = new ClockwiseSpiralController(3, 3);
        
        assertThat(ClockwiseSpiralController.makeMatrix(), is(new int[][] {
            {1, 2, 3},
            {8, 9, 4},
            {7, 6, 5}
        }));
    }
    
    @Test
    public void testClockwiseSpiral3x5() {
        ClockwiseSpiralController ClockwiseSpiralController = new ClockwiseSpiralController(3, 5);
        
        assertThat(ClockwiseSpiralController.makeMatrix(), is(new int[][] {
            {1 , 2, 3, 4, 5},
            {12,13,14,15, 6},
            {11,10, 9, 8, 7}
        }));
    }
}
