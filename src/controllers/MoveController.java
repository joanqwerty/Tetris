package controllers;

import java.util.Vector;

import models.Coordinate;
import models.Game;
import models.Blocks.Block;
import models.Blocks.Blocks;

public class MoveController {
	private Game game;

	public MoveController(Game game) {
		this.game = game;
	}

	public void reset() {
		game.reset();
	}

	public boolean isGameOver() {
		return game.isGameOver();
	}

	public void rotate() {
		game.rotate();
	}

	public void createBlock() {
		game.createBlock();
	}

	public Block getBlock() {
		return game.getBlock();
	}

	public void cleanFullRows() {
		game.cleanFullRows();
	}

	public Blocks getColor() {
		return game.getColor();
	}

	public void moveLeft() {
		game.moveLeft();
	}

	public void moveRigth() {
		game.moveRight();
	}

	public void moveDown() {
		game.moveDown();
	}

	public Vector<Coordinate> getCoordinates() {
		return game.getCoordinates();
	}

	public void updateBoard() {
		game.updateBoard();
	}
}
