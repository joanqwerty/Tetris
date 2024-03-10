package models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class Board {

	public static final int WIDTH = 10, HEIGHT = 20;
	private Vector<Coordinate> coordinates;

	public Board() {
		init();
	}

	public void init() {
		coordinates = new Vector<Coordinate>();
	}

	public boolean isGameOver() {
		return false;
	}

	public void addCoordinates(Set<Coordinate> coordinates) {
		for (Coordinate coordinate : coordinates) {
			this.coordinates.add(coordinate.clone());
		}
	}

	public boolean isColision(Coordinate coordinate) {
		for (Coordinate _coordinate : coordinates) {
			if (coordinate.getRow() == _coordinate.getRow() && coordinate.getColumn() == _coordinate.getColumn()) {
				return true;
			}
		}

		return false;
	}

	public boolean isOutside(Coordinate coordinate) {
		return coordinate.getColumn() < 0 || coordinate.getColumn() > WIDTH - 1 || coordinate.getRow() > HEIGHT - 1;
	}

	public void split() {
		for (int i = 0; i < coordinates.size() - 1; i++) {
			for (int j = i + 1; j < coordinates.size(); j++) {
				if (coordinates.get(j).getRow() > coordinates.get(i).getRow()) {
					Coordinate aux = coordinates.get(j);
					coordinates.setElementAt(coordinates.get(i), j);
					coordinates.setElementAt(aux, i);
				}
			}
		}
	}

	public void cleanFullRows() {
		Map<Integer, Set<Integer>> rows = new HashMap<Integer, Set<Integer>>(HEIGHT);
		for (int i = 0; i < rows.size(); i++) {
			rows.put(i, new HashSet<Integer>());
		}

		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < coordinates.size(); j++) {
				if (coordinates.get(j).getRow() == i) {
					if (rows.get(i) != null) {
						rows.get(i).add(j);
					}
				}
			}
		}

		for (int i = 0; i < rows.size(); i++) {
			if (rows.get(i).size() == WIDTH) {
				for (Integer index : rows.get(i)) {
					coordinates.removeElementAt(index);
				}

			}
		}

	}

	public void update() {
		Vector<Coordinate> coordinates = getCoordinates();
		split();

		for (Coordinate coordinate : coordinates) {
			Coordinate clone = coordinate.clone();
			clone.moveDown();

			if (isOutside(clone) && isColision(clone)) {
				coordinate.moveDown();
			}
		}
	}

	public Vector<Coordinate> getCoordinates() {
		return coordinates;
	}

}
