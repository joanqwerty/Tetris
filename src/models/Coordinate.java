package models;

public class Coordinate implements Cloneable {
	private int row, column;

	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public Coordinate(Coordinate coordinate) {
		this(coordinate.getRow(), coordinate.getColumn());
	}

	public void moveUp() {
		this.row--;
	}

	public void moveDown() {
		this.row++;
	}

	public void moveLeft() {
		this.column--;
	}

	public void moveRigth() {
		this.column++;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public Coordinate clone() {
		return new Coordinate(this);
	}
}
