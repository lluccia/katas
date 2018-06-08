package matrixspiral;

public class MovableSpy implements Movable {

    private String movements = "";
    
    public void moveRight() {
        movements += "R";
    }

    public void moveLeft() {
        movements += "L";
    }

    public void moveDown() {
        movements += "D";
    }

    public void moveUp() {
        movements += "U";
    }

    public int getRow() {
        return 0;
    }

    public int getColumn() {
        return 0;
    }
    
    public String getMovements() {
        return movements;
    }

}
