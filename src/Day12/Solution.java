package Day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
	public static void main(String[] args) throws IOException {
		String file = Files.readString(Path.of("inputFiles/Day12.txt"));
		HillClimb h = new HillClimb(file);
		System.out.println("Part 1 -> " + h.shortestPathPart1());
		System.out.println("Part 2 -> " + h.shortestPathPart2());
	}
}
