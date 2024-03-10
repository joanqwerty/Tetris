package models.Blocks;

import models.Coordinate;
import models.RotateState;

public class BlockI extends Block {

	public BlockI() {
		super();
		type = Blocks.I;
	}

	@Override
	public void initialize() {
		coordinates.get(RotateState.UP).add(new Coordinate(2, 3));
		coordinates.get(RotateState.UP).add(new Coordinate(3, 3));
		coordinates.get(RotateState.UP).add(new Coordinate(4, 3));
		coordinates.get(RotateState.UP).add(new Coordinate(5, 3));

		coordinates.get(RotateState.RIGHT).add(new Coordinate(4, 2));
		coordinates.get(RotateState.RIGHT).add(new Coordinate(4, 3));
		coordinates.get(RotateState.RIGHT).add(new Coordinate(4, 4));
		coordinates.get(RotateState.RIGHT).add(new Coordinate(4, 5));

		coordinates.get(RotateState.DOWN).add(new Coordinate(2, 3));
		coordinates.get(RotateState.DOWN).add(new Coordinate(3, 3));
		coordinates.get(RotateState.DOWN).add(new Coordinate(4, 3));
		coordinates.get(RotateState.DOWN).add(new Coordinate(5, 3));

		coordinates.get(RotateState.LEFT).add(new Coordinate(4, 2));
		coordinates.get(RotateState.LEFT).add(new Coordinate(4, 3));
		coordinates.get(RotateState.LEFT).add(new Coordinate(4, 4));
		coordinates.get(RotateState.LEFT).add(new Coordinate(4, 5));

	}

}
