package Day12;

import AuxiliarClasses.Day;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day12 extends Day {
	private final HillClimb hillClimb;

	public Day12() throws IOException {
		super(12);
		hillClimb = new HillClimb(Files.readString(Path.of(super.getFile())));
	}

	@Override
	public String Part1() {
		return String.valueOf(hillClimb.shortestPathPart1());
	}

	@Override
	public String Part2() {
		return String.valueOf(hillClimb.shortestPathPart2());
	}
}
