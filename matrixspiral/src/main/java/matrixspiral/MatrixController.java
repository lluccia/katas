package matrixspiral;

public class MatrixController implements Movable {

	public class MoveOutOfBoundsException extends RuntimeException {}

	private int rows;
	private int columns;
	
	private int row = 0;
	private int column = 0;
	
	
	public MatrixController(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setPosition(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public void moveRight() {
		if (column == columns - 1)
			throw new MoveOutOfBoundsException();
			
		column++;
	}

	public void moveLeft() {
		if (column == 0)
			throw new MoveOutOfBoundsException();
		
		column--;
	}

	public void moveDown() {
		if (row == rows - 1)
			throw new MoveOutOfBoundsException();
		
		row++;
	}

	public void moveUp() {
		if (row == 0)
			throw new MoveOutOfBoundsException();
			
		row--;
	}
}
