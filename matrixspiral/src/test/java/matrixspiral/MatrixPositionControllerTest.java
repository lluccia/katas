package matrixspiral;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MatrixPositionControllerTest {

    @Test
    public void canCreateMatrixController() {
        new MatrixController(1,1);
    }
    
    @Test
    public void initialPositionShouldBe0x0() {
        MatrixController matrixController = new MatrixController(1,1);
        
        assertThat(matrixController.getRow(), is(0));
        assertThat(matrixController.getColumn(), is(0));
    }
    
    @Test
    public void canMoveRight() {
        MatrixController matrixController = new MatrixController(2,2);
        
        matrixController.moveRight();
        
        assertThat(matrixController.getRow(), is(0));
        assertThat(matrixController.getColumn(), is(1));
    }
    
    @Test
    public void canMoveDown() {
        MatrixController matrixController = new MatrixController(2,2);
        
        matrixController.moveDown();
        
        assertThat(matrixController.getRow(), is(1));
        assertThat(matrixController.getColumn(), is(0));
    }
    
    @Test
    public void canMoveLeft() {
        MatrixController matrixController = new MatrixController(2,2);
        
        matrixController.setPosition(1, 1);
        
        matrixController.moveLeft();
        
        assertThat(matrixController.getRow(), is(1));
        assertThat(matrixController.getColumn(), is(0));
    }
    
    @Test
    public void canMoveUp() {
        MatrixController matrixController = new MatrixController(2,2);
        
        matrixController.setPosition(1, 1);
        
        matrixController.moveUp();
        
        assertThat(matrixController.getRow(), is(0));
        assertThat(matrixController.getColumn(), is(1));
    }
    
    @Test(expected=MatrixController.MoveOutOfBoundsException.class)
    public void movingLeftPastBoundsShouldThrowException() {
        Movable matrixController = new MatrixController(1,1);
        
        matrixController.moveLeft();
    }
    
    @Test(expected=MatrixController.MoveOutOfBoundsException.class)
    public void movingUpPastBoundsShouldThrowException() {
        Movable matrixController = new MatrixController(1,1);
        
        matrixController.moveUp();
    }
    
    @Test(expected=MatrixController.MoveOutOfBoundsException.class)
    public void movingRightPastBoundsShouldThrowException() {
        Movable matrixController = new MatrixController(1,1);
        
        matrixController.moveRight();
    }
    
    @Test(expected=MatrixController.MoveOutOfBoundsException.class)
    public void movingDownPastBoundsShouldThrowException() {
        Movable matrixController = new MatrixController(1,1);
        
        matrixController.moveDown();
    }
}
