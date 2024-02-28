package Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import AuxiliarClasses.Day;

public class Day2 extends Day {
	private final List<Round> Game;

	public Day2() throws IOException {
		super(2);
		Game = Files.readString(Path.of(super.getFile())).lines().map(Round::new).toList();
	}

	@Override
	public String Part1() {
		return Game.stream().map(Round::getPart1Score).reduce(0, Integer::sum).toString();
	}

	@Override
	public String Part2() {
		return Game.stream().map(Round::getPart2Score).reduce(0, Integer::sum).toString();
	}
}
