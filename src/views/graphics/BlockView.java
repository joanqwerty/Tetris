package views.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import controllers.GameController;
import models.Coordinate;

public class BlockView {
	public static final int WIDTH = 300;

	GameController moveController;

	public BlockView(GameController moveController) {
		this.moveController = moveController;
	}

	public void render(Graphics g) {
		int BLOCK_SIZE = WIDTH / 12;

		for (Coordinate coordinate : moveController.getBlock().getCoordinates()) {
			int row = coordinate.getRow() + 1;
			int col = coordinate.getColumn() + 1;

			g.setColor(new Color(0, 210, 0));
			Polygon polygon = new Polygon();
			polygon.addPoint(col * BLOCK_SIZE, row * BLOCK_SIZE);
			polygon.addPoint((col * BLOCK_SIZE) + BLOCK_SIZE, row * BLOCK_SIZE);
			polygon.addPoint((col * BLOCK_SIZE) + BLOCK_SIZE, row * BLOCK_SIZE + BLOCK_SIZE);
			g.fillPolygon(polygon);

			g.setColor(new Color(0, 180, 0));
			polygon = new Polygon();
			polygon.addPoint(col * BLOCK_SIZE, row * BLOCK_SIZE);
			polygon.addPoint(col * BLOCK_SIZE, row * BLOCK_SIZE + BLOCK_SIZE);
			polygon.addPoint(col * BLOCK_SIZE + BLOCK_SIZE, row * BLOCK_SIZE + BLOCK_SIZE);
			g.fillPolygon(polygon);
		}
	}
}
