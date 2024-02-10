package Day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
	public static void main(String[] args) throws IOException {
		String monkeyTest = Files.readString(Path.of("inputFiles/Day11.txt"));
		Game game = new Game(monkeyTest);
		System.out.println("Part 1 -> " + game.getPart1());
		game = new Game(monkeyTest);
		System.out.println("Part 2 -> " + game.getPart2());
	}
}
