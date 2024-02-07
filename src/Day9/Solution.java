package Day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
	public static void main(String[] args) throws IOException {
		Path filePath = Path.of("src/Day9/input.txt");
		Part1(filePath);
		Part2(filePath);
	}

	private static void Part2(Path filePath) throws IOException {
		Bridge p2 = new Bridge(10);
		Files.readString(filePath).lines().forEach(line -> p2.move(line.split(" ")[0], line.split(" ")[1]));
		System.out.println("Part 1 -> " + p2.howManyPositionsTailVisited());
	}

	private static void Part1(Path filePath) throws IOException {
		Bridge p1 = new Bridge(2);
		Files.readString(filePath).lines().forEach(line -> p1.move(line.split(" ")[0], line.split(" ")[1]));
		System.out.println("Part 1 -> " + p1.howManyPositionsTailVisited());
	}

}
