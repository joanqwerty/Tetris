package models.Blocks;

import models.Coordinate;
import models.RotateState;

public class BlockJ extends Block{
	
	public BlockJ() {
		type = Blocks.J;
	}
	
	@Override
	public void initialize() {
		coordinates.get(RotateState.UP).add(new Coordinate(2, 2));
        coordinates.get(RotateState.UP).add(new Coordinate(3, 2));
        coordinates.get(RotateState.UP).add(new Coordinate(4, 2));
        coordinates.get(RotateState.UP).add(new Coordinate(4, 1));

        coordinates.get(RotateState.RIGHT).add(new Coordinate(3, 4));
        coordinates.get(RotateState.RIGHT).add(new Coordinate(3, 3));
        coordinates.get(RotateState.RIGHT).add(new Coordinate(3, 2));
        coordinates.get(RotateState.RIGHT).add(new Coordinate(2, 2));

        coordinates.get(RotateState.DOWN).add(new Coordinate(5, 3));
        coordinates.get(RotateState.DOWN).add(new Coordinate(4, 3));
        coordinates.get(RotateState.DOWN).add(new Coordinate(3, 3));
        coordinates.get(RotateState.DOWN).add(new Coordinate(3, 4));

        coordinates.get(RotateState.LEFT).add(new Coordinate(4, 1));
        coordinates.get(RotateState.LEFT).add(new Coordinate(4, 2));
        coordinates.get(RotateState.LEFT).add(new Coordinate(4, 3));
        coordinates.get(RotateState.LEFT).add(new Coordinate(5, 3));
	}

}
