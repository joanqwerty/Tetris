package models.Blocks;

import models.Coordinate;
import models.RotateState;

public class BlockO extends Block {

	public BlockO() {
		super();
		type = Blocks.O;
	}
	
	@Override
	public void initialize() {
		coordinates.get(RotateState.UP).add(new Coordinate(2, 2));
        coordinates.get(RotateState.UP).add(new Coordinate(2, 3));
        coordinates.get(RotateState.UP).add(new Coordinate(3, 2));
        coordinates.get(RotateState.UP).add(new Coordinate(3, 3));

        coordinates.get(RotateState.RIGHT).add(new Coordinate(2, 2));
        coordinates.get(RotateState.RIGHT).add(new Coordinate(2, 3));
        coordinates.get(RotateState.RIGHT).add(new Coordinate(3, 2));
        coordinates.get(RotateState.RIGHT).add(new Coordinate(3, 3));

        coordinates.get(RotateState.DOWN).add(new Coordinate(2, 2));
        coordinates.get(RotateState.DOWN).add(new Coordinate(2, 3));
        coordinates.get(RotateState.DOWN).add(new Coordinate(3, 2));
        coordinates.get(RotateState.DOWN).add(new Coordinate(3, 3));

        coordinates.get(RotateState.LEFT).add(new Coordinate(2, 2));
        coordinates.get(RotateState.LEFT).add(new Coordinate(2, 3));
        coordinates.get(RotateState.LEFT).add(new Coordinate(3, 2));
        coordinates.get(RotateState.LEFT).add(new Coordinate(3, 3));
	}

}
