package Day9;

import static Day9.DIRECTION.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bridge {
	private final List<Pos> knotList;
	private final Map<String, DIRECTION> directionMap = Map.of("R", RIGHT, "D", DOWN, "U", UP, "L", LEFT);
	private final List<Pos> positionsThatLastKnotVisited;

	public Bridge(int i) {
		knotList = new ArrayList<>();
		for (int j = 0; j < i; j++) {
			knotList.add(new Pos(0, 0));
		}
		positionsThatLastKnotVisited = new ArrayList<>();
		positionsThatLastKnotVisited.add(knotList.getLast().copy());
	}

	private boolean shouldUpdatePositionsVisited() {
		Pos lastPosition = knotList.getLast();
		for (Pos pos : positionsThatLastKnotVisited) {
			if (lastPosition.equals(pos))
				return false;
		}
		return true;
	}

	public void move(String direction, String howManyTimes) {
		DIRECTION d = directionMap.get(direction);
		List<Pair<Pos, Pos>> listOfPairs = makeListOfPairs();
		for (int i = 0; i < Integer.parseInt(howManyTimes); i++) {
			knotList.getFirst().move(d);
			for (Pair<Pos, Pos> pair : listOfPairs) {
				if (shouldKnotMove(pair.first(), pair.second()))
					moveKnot(pair.first, pair.second);
			}
			if (shouldUpdatePositionsVisited())
				positionsThatLastKnotVisited.add(knotList.getLast().copy());
		}
	}

	private List<Pair<Pos, Pos>> makeListOfPairs() {
		List<Pair<Pos, Pos>> listOfPairs = new ArrayList<>();
		List<Pos> tempList = new ArrayList<>(knotList);
		for (int i = 0; i < tempList.size() - 1; i++) {
			listOfPairs.add(new Pair<>(tempList.get(i), tempList.get(i + 1)));
		}
		return listOfPairs;
	}

	private void moveKnot(Pos p1, Pos p2) {
		if (p1.getX() > p2.getX())
			p2.move(RIGHT);
		if (p1.getX() < p2.getX())
			p2.move(LEFT);
		if (p1.getY() > p2.getY())
			p2.move(UP);
		if (p1.getY() < p2.getY())
			p2.move(DOWN);
	}

	private boolean shouldKnotMove(Pos p1, Pos p2) {
		return Math.abs(p1.getX() - p2.getX()) > 1 || Math.abs(p1.getY() - p2.getY()) > 1;
	}

	public int howManyPositionsTailVisited() {
		return positionsThatLastKnotVisited.size();
	}

	private record Pair<T, U>(T first, U second) {

	}
}
