package matrixspiral;

public interface Movable {

    void moveRight();
    void moveLeft();
    void moveDown();
    void moveUp();
    
    int getRow();
    int getColumn();

}