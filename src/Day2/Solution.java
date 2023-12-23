package Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws IOException {
		List<Round> Game = Files.readString(Path.of("src/ao02/input.txt")).lines().map(Round::new).toList();
		System.out.println("Part 1 -> " + Game.stream().map(Round::getPart1Score).reduce(0, Integer::sum));
		System.out.println("Part 1 -> " + Game.stream().map(Round::getPart2Score).reduce(0, Integer::sum));
	}
}
