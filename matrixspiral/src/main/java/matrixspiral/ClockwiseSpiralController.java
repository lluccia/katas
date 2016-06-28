package matrixspiral;

public class ClockwiseSpiralController {

	private enum Direction {
		RIGHT, DOWN, LEFT, UP
	}

	private Direction currentDirection = Direction.RIGHT;

	private Movable movable;

	private int rows;
	private int columns;

	private int rowMoveCount = 0;
	private int columnMoveCount = 0;

	private int currentColumnMovements;
	private int currentRowMovements;

	public ClockwiseSpiralController(int rows, int columns) {
		this.movable = new MatrixController(rows, columns);
		this.rows = rows;
		this.columns = columns;

		this.currentColumnMovements = columns - 1;
		this.currentRowMovements = rows - 2;
	}

	public void setMovable(Movable movable) {
		this.movable = movable;
	}

	public int[][] makeMatrix() {
		int[][] matrix = new int[rows][columns];

		int counter = 1;

		int numberOfCells = rows * columns;
		for (int i = 0; i < numberOfCells; i++) {
			matrix[movable.getRow()][movable.getColumn()] = counter++;

			if (i < numberOfCells - 1) {
				switchDirectionIfRequired();
				makeMovement();
			}

		}

		return matrix;
	}

	private void switchDirectionIfRequired() {
		if (currentDirection == Direction.RIGHT && columnMoveCount++ == currentColumnMovements) {
			currentDirection = Direction.DOWN;
		} else if (currentDirection == Direction.DOWN && rowMoveCount++ == currentRowMovements) {
			currentDirection = Direction.LEFT;
			currentRowMovements--;
		} else if (currentDirection == Direction.LEFT && --columnMoveCount == 1) {
			currentDirection = Direction.UP;
			currentColumnMovements--;
		} else if (currentDirection == Direction.UP && --rowMoveCount == 1) {
			currentDirection = Direction.RIGHT;
		}
	}

	private void makeMovement() {
		switch (currentDirection) {
		case RIGHT:
			movable.moveRight();
			break;
		case LEFT:
			movable.moveLeft();
			break;
		case UP:
			movable.moveUp();
			break;
		case DOWN:
			movable.moveDown();
			break;
		}
	}

}
