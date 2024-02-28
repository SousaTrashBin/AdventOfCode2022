package Day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import AuxiliarClasses.Day;

public class Day11 extends Day {
	private final Game monkeyGame1;
	private final Game monkeyGame2;

	public Day11() throws IOException {
		super(11);
		monkeyGame1 = new Game(Files.readString(Path.of(super.getFile())));
		monkeyGame2 = new Game(Files.readString(Path.of(super.getFile())));
	}

	@Override
	public String Part1() {
		return String.valueOf(monkeyGame1.getPart1());
	}

	@Override
	public String Part2() {
		return String.valueOf(monkeyGame2.getPart2());
	}
}
