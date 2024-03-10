package models.Blocks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import models.Coordinate;
import models.RotateState;

public abstract class Block {
	protected Map<RotateState, Set<Coordinate>> coordinates;

	protected RotateState rotateState;
	protected Blocks type;

	public Block() {
		this.coordinates = new HashMap<>();
		initCoordinates();
		initializeState();
		initialize();
	}

	protected void initCoordinates() {
		for (RotateState state : RotateState.values()) {
			coordinates.put(state, new HashSet<>());
		}
	}

	protected void initializeState() {
		Random random = new Random(System.currentTimeMillis());

		int length = RotateState.values().length;

		rotateState = RotateState.values()[random.nextInt(length)];
	}

	public abstract void initialize();

	public Blocks getColor() {
		return type;
	}

	public void rotateRight() {
		if (rotateState.ordinal() == RotateState.values().length - 1) {
			rotateState = RotateState.values()[0];
			return;
		}
		rotateState = RotateState.values()[rotateState.ordinal() + 1];
	}

	public void rotateLeft() {
		if (rotateState.ordinal() == 0) {
			int lenght = RotateState.values().length;
			rotateState = RotateState.values()[lenght - 1];
			return;
		}
		rotateState = RotateState.values()[rotateState.ordinal() - 1];
	}

	public void moveUp() {
		for (RotateState rotateState : coordinates.keySet()) {
			for (Coordinate coordinate : coordinates.get(rotateState)) {
				coordinate.moveUp();
			}
		}
	}

	public void moveDown() {
		for (RotateState rotateState : coordinates.keySet()) {
			for (Coordinate coordinate : coordinates.get(rotateState)) {
				coordinate.moveDown();
			}
		}
	}

	public void moveLeft() {
		for (RotateState rotateState : coordinates.keySet()) {
			for (Coordinate coordinate : coordinates.get(rotateState)) {
				coordinate.moveLeft();
			}
		}
	}

	public void moveRigth() {
		for (RotateState rotateState : coordinates.keySet()) {
			for (Coordinate coordinate : coordinates.get(rotateState)) {
				coordinate.moveRigth();
			}
		}
	}

	public HashSet<Coordinate> getCoordinates() {
		return (HashSet<Coordinate>) coordinates.get(rotateState);
	}
}
