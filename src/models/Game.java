package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

import models.Blocks.Block;
import models.Blocks.BlockI;
import models.Blocks.BlockJ;
import models.Blocks.BlockL;
import models.Blocks.BlockO;
import models.Blocks.BlockT;
import models.Blocks.Blocks;

public class Game {
	private Board board;
	private Block block;
	private List<Block> list;

	public Game() {
		board = new Board();
		initList();
		createBlock();
	}

	private void initList() {
		list = new ArrayList<Block>();
		list.add(new BlockT());
		list.add(new BlockI());
		list.add(new BlockO());
		list.add(new BlockL());
		list.add(new BlockJ());
	}

	public void reset() {
		initList();
		board.init();
		createBlock();
	}

	public boolean isGameOver() {
		return board.isGameOver();
	}

	public void createBlock() {
		if (list.size() == 0) {
			initList();
		}

		Random random = new Random(System.currentTimeMillis());
		int index = random.nextInt(list.size());
		block = list.get(index);
		list.remove(index);
	}

	public Block getBlock() {
		return block;
	}

	public Blocks getColor() {
		return block.getColor();
	}

	public void rotate() {
		block.rotateRight();

		if (!isOutside(block.getCoordinates()) && !isColision(block.getCoordinates())) {
			return;
		}
		block.rotateLeft();
	}

	public void moveLeft() {
		block.moveLeft();
		if (!isOutside(block.getCoordinates()) && !isColision(block.getCoordinates())) {
			return;
		}

		block.moveRigth();
	}

	public void moveRight() {
		block.moveRigth();
		if (!isOutside(block.getCoordinates()) && !isColision(block.getCoordinates())) {
			return;
		}

		block.moveLeft();

	}

	public void moveDown() {
		block.moveDown();
		if (isOutside(block.getCoordinates()) || isColision(block.getCoordinates())) {
			block.moveUp();
			board.addCoordinates(block.getCoordinates());
			createBlock();
		}
	}

	private boolean isColision(Set<Coordinate> coordinates) {
		for (Coordinate coordinate : coordinates) {
			if (board.isColision(coordinate)) {
				return true;
			}
		}

		return false;
	}

	private boolean isOutside(Set<Coordinate> coordinates) {
		for (Coordinate coordinate : coordinates) {
			if (board.isOutside(coordinate)) {
				return true;
			}
		}

		return false;
	}

	public void cleanFullRows() {
		board.cleanFullRows();
	}

	public Vector<Coordinate> getCoordinates() {
		return board.getCoordinates();
	}

	public void updateBoard() {
		board.update();
	}
}
