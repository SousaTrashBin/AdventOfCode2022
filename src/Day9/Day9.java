package Day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import AuxiliarClasses.Day;

public class Day9 extends Day {
	private final Bridge part1Bridge = new Bridge(2);
	private final Bridge part2Bridge = new Bridge(10);
	List<String> actions;

	public Day9() throws IOException {
		super(9);
		actions = Files.readString(Path.of(super.getFile())).lines().toList();
	}

	@Override
	public String Part1() {
		actions.forEach(line -> part1Bridge.move(line.split(" ")[0], line.split(" ")[1]));
		return String.valueOf(part1Bridge.howManyPositionsTailVisited());
	}

	@Override
	public String Part2() {
		actions.forEach(line -> part2Bridge.move(line.split(" ")[0], line.split(" ")[1]));
		return String.valueOf(part2Bridge.howManyPositionsTailVisited());
	}
}
