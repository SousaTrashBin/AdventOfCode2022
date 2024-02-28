package Day12;

import java.util.ArrayList;
import java.util.List;

import AuxiliarClasses.Direction;
import AuxiliarClasses.Pos;

public class HillClimb {
	private final int[][] grid;
	private final Pos S;
	private final Pos E;

	public HillClimb(String file) {
		grid = file.lines().map(x -> x.chars().toArray()).toArray(int[][]::new);
		S = findPosition('S');
		E = findPosition('E');
	}

	private Pos findPosition(char s) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == (int) s)
					return new Pos(j, i);
			}
		}
		return null;
	}

	public List<Pos> getAllStartingPositions() {
		List<Pos> startingPositions = new ArrayList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == (int) 'a' || grid[i][j] == (int) 'S')
					startingPositions.add(new Pos(j, i));
			}
		}
		return startingPositions;
	}

	public int shortestPathPart1() {
		return shortestPath(S);
	}

	public int shortestPathPart2() {
		return getAllStartingPositions().stream().map(this::shortestPath).min(Integer::compare).orElse(-1);
	}

	public int shortestPath(Pos startingPosition) {
		List<Pos> startingPositions = List.of(startingPosition);
		List<Pos> positionsToVerify = new ArrayList<>();
		boolean[][] visitedGrid = new boolean[grid.length][grid[0].length];
		int steps = 0;
		while (startingPositions.stream().filter(x -> x.equals(E)).toList().isEmpty()) {
			for (Pos pos : startingPositions) {
				int currentHeight = getHeight(pos);
				tryToAdd(pos.moveTo(Direction.UP), currentHeight, positionsToVerify, visitedGrid);
				tryToAdd(pos.moveTo(Direction.LEFT), currentHeight, positionsToVerify, visitedGrid);
				tryToAdd(pos.moveTo(Direction.RIGHT), currentHeight, positionsToVerify, visitedGrid);
				tryToAdd(pos.moveTo(Direction.DOWN), currentHeight, positionsToVerify, visitedGrid);
			}
			startingPositions = positionsToVerify;
			positionsToVerify = new ArrayList<>();
			steps++;
			if (startingPositions.isEmpty())
				return Integer.MAX_VALUE;
		}
		return steps;
	}

	private void tryToAdd(Pos pos, int currentHeight, List<Pos> positionsToVerify, boolean[][] visitedGrid) {
		if (!pos.equals(S) && isOnGrid(pos) && getHeight(pos) <= currentHeight + 1
				&& !visitedGrid[pos.getY()][pos.getX()]) {
			visitedGrid[pos.getY()][pos.getX()] = true;
			positionsToVerify.add(pos);
		}
	}

	private int getHeight(Pos pos) {
		if (pos.equals(S))
			return 'a';
		if (pos.equals(E))
			return 'z';
		return grid[pos.getY()][pos.getX()];
	}

	private boolean isOnGrid(Pos p) {
		return p.getY() >= 0 && p.getY() < grid.length && p.getX() >= 0 && p.getX() < grid[0].length;
	}

}
