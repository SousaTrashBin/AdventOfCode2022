package Day8;

import AuxiliarClasses.Day;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day8 extends Day {
	private final TreeMap grid;

	public Day8() throws IOException {
		super(8);
		grid = new TreeMap(Files.readString(Path.of(super.getFile())));
	}

	@Override
	public String Part1() {
		return String.valueOf(grid.getVisibleGrids());
	}

	@Override
	public String Part2() {
		return String.valueOf(grid.biggestScenicScore());
	}
}
