package views.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Iterator;
import java.util.Vector;

import controllers.MoveController;
import models.Coordinate;

public class BoardView {

	private int WIDTH = 300;
	public Vector<Coordinate> coordinates;

	private int[][] board = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, };

	private MoveController moveController;

	public BoardView(MoveController moveController) {
		this.moveController = moveController;
		coordinates = new Vector<Coordinate>();
	}

	private void drawGrid(int row, int col, Graphics g) {
		int BLOCK_SIZE = WIDTH / 12;

		g.setColor(new Color(210, 210, 210));
		Polygon polygon = new Polygon();
		polygon.addPoint(col * BLOCK_SIZE, row * BLOCK_SIZE);
		polygon.addPoint((col * BLOCK_SIZE) + BLOCK_SIZE, row * BLOCK_SIZE);
		polygon.addPoint((col * BLOCK_SIZE) + BLOCK_SIZE, row * BLOCK_SIZE + BLOCK_SIZE);
		g.fillPolygon(polygon);

		g.setColor(new Color(180, 180, 180));
		polygon = new Polygon();
		polygon.addPoint(col * BLOCK_SIZE, row * BLOCK_SIZE);
		polygon.addPoint(col * BLOCK_SIZE, row * BLOCK_SIZE + BLOCK_SIZE);
		polygon.addPoint(col * BLOCK_SIZE + BLOCK_SIZE, row * BLOCK_SIZE + BLOCK_SIZE);
		g.fillPolygon(polygon);
	}

	public void render(Graphics g) {

		moveController.cleanFullRows();
		moveController.updateBoard();

		coordinates = moveController.getCoordinates();

		synchronized (coordinates) {

			for (Iterator<Coordinate> iterator = coordinates.iterator(); iterator.hasNext();) {
				Coordinate coordinate = iterator.next();
				drawGrid(coordinate.getRow() + 1, coordinate.getColumn() + 1, g);

			}
		}

		for (int row = 0; row < 22; row++) {
			for (int col = 0; col < 12; col++) {
				if (board[row][col] == 1) {
					drawGrid(row, col, g);
				}
			}
		}
	}
}
